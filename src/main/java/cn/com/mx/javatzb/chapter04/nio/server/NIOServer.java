package cn.com.mx.javatzb.chapter04.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

public class NIOServer {

	public final static int BYTE_BUFFER_SIZE = 8192;
	
	public final static ByteBuffer CLIENT_BYTE_BUFFER = ByteBuffer.allocate(BYTE_BUFFER_SIZE);
	
	public final static int DEFAULT_PORT = 8888;
	
	public static void main(String []args) throws IOException {
		Selector selector = createSelector();
		logInfo("���������Ѿ��Ѿ��򿪶˿ڣ�" + DEFAULT_PORT);
		try {
			while (true) {
				selector.select();
				Set<SelectionKey> selectionKeySet = selector.selectedKeys();
				for (SelectionKey selectionKey : selectionKeySet) {
					SelectionKeyProcessor selectionKeyProcessor = new SelectionKeyProcessor(
								selectionKey, selector);
					selectionKeyProcessor.processKey();
				}
				selectionKeySet.clear();
			}
		}finally {
			selector.close();
		}
	}
	
	private static Selector createSelector() throws IOException {
		ServerSocketChannel server = ServerSocketChannel.open();  //��ServerSocketChannel
		Selector selector = Selector.open();                      //����һ��ѡ����
		server.socket().bind(new InetSocketAddress(DEFAULT_PORT)); //Channel�а�һ���˿�
		server.configureBlocking(false);                           //��Ϊ������ģʽ
		server.register(selector, SelectionKey.OP_ACCEPT);         //ѡ����ע����Channel�ϣ�  ע������¼�(��Ϊ�������������ǽ�������)
		return selector;
	}
}
