package cn.com.mx.javatzb.chapter04.nio.server;

import static chapter04.socket.Commons.DEFAULT_MESSAGE_CHARSET;
import static chapter04.socket.Commons.closeStreams;
import static chapter04.socket.Commons.logInfo;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SelectionKeyProcessor {

	private SelectionKey selectionKey;

	private Selector selector;

	public SelectionKeyProcessor(SelectionKey selectionKey, Selector selector) {
		this.selectionKey = selectionKey;
		this.selector = selector;
	}

	public void processKey() throws IOException {
		try {
			if (selectionKey.isAcceptable()) {//����
				processAccept();
			} else if (selectionKey.isReadable()) {//��ȡ
				processRead();
			} else if (selectionKey.isWritable()) {//д
				processWrite();
			}
		}catch(IOException e) {//IO�쳣��Ҫ�رգ�����ᵼ�������Ƶر��?��Ϊͨ��û����ͻ�һֱ�����
			SelectableChannel channel = selectionKey.channel();
			if(channel instanceof SocketChannel) {
				DownloadFileProcessor downloadFileProcessor = (DownloadFileProcessor)selectionKey.attachment();
				closeStreams(downloadFileProcessor , channel);
				logInfo("��������IO�쳣������.....");
			}
		}
	}

	private void processAccept() throws IOException {
		//System.out.println("һ���µ�����................");
		ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();//�����ȡ��Server�򿪵�ͨ��
		SocketChannel channel = server.accept();//����һ�������Channel��ͨ��
		channel.configureBlocking(false);//�����������ͨ������Ϊ������ģʽ
		//System.out.println(channel.socket().getSendBufferSize());
		//channel.socket().setSendBufferSize(16 * 1024);
		channel.register(selector, SelectionKey.OP_READ);//�����ͨ��ע��һ����ȡ�¼�
	}

	private void processRead() throws IOException {
		SocketChannel channel = (SocketChannel)selectionKey.channel();//��ʱȡ����ΪprocessAccept()ע���˵�ͨ��
		channel.read(NIOServer.CLIENT_BYTE_BUFFER);
		//����ת���ַ���Ҳ�����Լ�ʹ��ת������CharsetDecoder�����
		byte[]bytes = new byte[NIOServer.CLIENT_BYTE_BUFFER.position()];
		NIOServer.CLIENT_BYTE_BUFFER.flip();//��ָ������ƫ�ƣ����ܵõ�׼ȷ�����
		NIOServer.CLIENT_BYTE_BUFFER.get(bytes);//��ȡ��Byte��
		NIOServer.CLIENT_BYTE_BUFFER.clear();
		logInfo("�ͻ�����Ϣ >>" + new String(bytes , DEFAULT_MESSAGE_CHARSET));//ת������ַ�

		SelectionKey writeSelectionKey = channel.register(selector , SelectionKey.OP_WRITE);//ע��һ��д��ѡ����
		writeSelectionKey.attach(new DownloadFileProcessor());//������԰�һ������selectionKey���У�������Ӧ�¼���ʱ�򣬿��Խ���ȡ��
	}

	private void processWrite() throws IOException {
		//System.out.println("����д����");
		SocketChannel channel = (SocketChannel)selectionKey.channel();
		DownloadFileProcessor downloadFileProcessor = (DownloadFileProcessor)selectionKey.attachment();//��ȡע��WRITE�¼��Ķ���
		int count = downloadFileProcessor.read();
		if(count <= 0) {
			closeStreams(downloadFileProcessor , channel);
			logInfo("���ؽ���.....");
		}else {
			channel.write(downloadFileProcessor.getFileByteBuffer());
		}
	}

}
