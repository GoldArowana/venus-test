package cn.com.mx.javatzb.chapter04.socket.server;

import static chapter04.socket.Commons.DEFAULT_BUFFER_LENGTH;
import static chapter04.socket.Commons.DEFAULT_MESSAGE_CHARSET;
import static chapter04.socket.Commons.GET_FILE;
import static chapter04.socket.Commons.SEND_B_FILE;
import static chapter04.socket.Commons.SEND_FILE;
import static chapter04.socket.Commons.SEND_MESSAGE;
import static chapter04.socket.Commons.SERVER_SAVE_BASE_PATH;
import static chapter04.socket.Commons.closeStream;
import static chapter04.socket.Commons.logInfo;
import static chapter04.socket.Commons.print;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;

import chapter04.socket.Commons;
import chapter04.socket.SocketWrapper;
import chapter04.socket.client.exceptions.DownloadNotExistsFileException;
import chapter04.socket.client.exceptions.SaveExistsFileException;

public class Worker extends Thread {

	private SocketWrapper socketWrapper;
	
	private String name;
	
	public Worker(SocketWrapper socketWrapper , String name) {
		this.socketWrapper = socketWrapper;
		this.name = name;
		logInfo("�����̣߳�" + name + " , ��ʼ�������տͻ��˴������......");
		this.start();//����
	}
	
	public void run() {
		while(true) {
			try {
				if(this.isInterrupted()) break;
				byte type = socketWrapper.readByte();
				switch(type) {
					case SEND_MESSAGE : processMessage(); break;
					case SEND_FILE : processFile(); break;
					case SEND_B_FILE : uploadFileContent(null); break;
					case GET_FILE : downloadFile(); break;
					default : 
				}
			}catch(SaveExistsFileException e) {
				logInfo(e.getMessage());
			}catch(DownloadNotExistsFileException e) {
				logInfo(e.getMessage());
			}catch(EOFException e) {
				logInfo("�ͻ��˹ر�socket���߳� :" + name + " ����ִ��.");
				break;//�Է�socket�Ѿ��Ͽ�
			}catch(SocketException e) {
				logInfo("Socket�쳣��" + e.getMessage() + "���߳� :" + name + " ����ִ��.");
				break;//socket�쳣
			}catch(Exception e) {
				e.printStackTrace();
				logInfo("�߳� :" + name + " ����ִ��.");
				break;
			}
		}
		this.socketWrapper.close();
	}
	
	public void interrupt() {
		if(this.isAlive()) 
			super.interrupt();
	}
	
	/**
	 * ����ͻ��˴�������Ϣ��
	 * @throws IOException 
	 */
	private void processMessage() throws IOException {
		int length = socketWrapper.readInt();
		byte[]message = new byte[length];
		socketWrapper.read(message);
		logInfo("�̣߳�" + name  + " ���ܵ����Կͻ��˴���message��Ϣ��" + new String(message , DEFAULT_MESSAGE_CHARSET));
	}
	
	/**
	 * ����ͻ��˴�������ͨ�ļ�
	 * @throws IOException
	 */
	private void processFile() throws IOException {
		//��ȡ�ַ�
		String charset = Commons.getCharsetNameByCode(socketWrapper.readByte());
		logInfo("�̣߳�" + name + "������Դ�ͻ��˷����ļ����ַ�Ϊ��" + charset);
		
		uploadFileContent(charset);
	}

	/**
	 * �ϴ��ļ�������ϸ
	 * @param charset
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	private void uploadFileContent(String charset) throws IOException,
			UnsupportedEncodingException, FileNotFoundException {
		FileOutputStream out = null;
		try {
			//��ȡ�ļ�����Լ��ļ���
			short length = socketWrapper.readShort();
			byte[]bytes = new byte[length];
			socketWrapper.readFull(bytes);
			String fileName = new String(bytes , DEFAULT_MESSAGE_CHARSET);
			logInfo("�̣߳�" + name + "������Դ�ͻ��˷����ļ�����Դ�ļ���Ϊ��" + fileName);
			
			String path = SERVER_SAVE_BASE_PATH + fileName;
			File file = new File(path);
			if(file.exists()) {
				throw new SaveExistsFileException(path);
			}
			socketWrapper.write(1);//��ʾ�ļ����Դ���
			out = new FileOutputStream(file);
			
			//��ȡ�ļ����ݣ����ǰ�沿������
			long fileLength = socketWrapper.readLong();
			logInfo("�̣߳�" + name + "������Դ�ͻ��˷����ļ����ļ�����Ϊ��" + fileLength);
			bytes = new byte[DEFAULT_BUFFER_LENGTH];
			int allLength = 0 , i = 0;
			while(allLength < fileLength) {
				int len = socketWrapper.read(bytes);
				allLength += len;
				out.write(bytes, 0, len);
				if(charset != null) {
					print(new String(bytes , charset));
				}
				if(i++ % 1024 == 0) {
					print(".");
				}
			}
			logInfo("\n�ļ�������ϲ����棬��ͻ��˷���ȷ����Ϣ , ʵ�ʽ������ݳ���Ϊ��" + fileLength);
			socketWrapper.write(1);
		}catch(SaveExistsFileException e) {
			socketWrapper.write(-1);
			throw e;
		}catch(RuntimeException e) {
			logInfo("\n�ļ�����ʧ�ܣ���ͻ��˷��ʹ�����Ϣ��");
			socketWrapper.write(-2);
			throw e;
		}finally {
			closeStream(out);
		}
	}
	
	/**
	 * �����ļ�����
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	private void downloadFile() throws IOException,
		UnsupportedEncodingException, FileNotFoundException {
		short fileNameLength = socketWrapper.readShort();
		byte []fileNameBytes = new byte[fileNameLength];
		socketWrapper.read(fileNameBytes);
		String fileName = new String(fileNameBytes , DEFAULT_MESSAGE_CHARSET);
		logInfo("�̣߳�" + name + "���ܿͻ��������ļ��������ļ���Ϊ��" + fileName);
		
		String absolatePath = SERVER_SAVE_BASE_PATH + fileName;
		File file = new File(absolatePath);
		if(file.exists()) {
			socketWrapper.write(1);
		}else {
			socketWrapper.write(-1);
			throw new DownloadNotExistsFileException(absolatePath);
		}
		socketWrapper.write(file.length());//�ļ�����
		socketWrapper.writeFile(absolatePath);//�ļ�
	}
}
