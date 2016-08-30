package cn.com.mx.javatzb.chapter04.aio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsynchronousServerTest {

	public static void main(String []args) throws IOException, InterruptedException, ExecutionException {
		AsynchronousChannelGroup group = AsynchronousChannelGroup.withCachedThreadPool(Executors.newFixedThreadPool(10), 2);
		AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open(group);
		serverChannel.bind(new InetSocketAddress("localhost" , 8888) , 128);
		Future<AsynchronousSocketChannel> future = serverChannel.accept();
		//serverChannel.accept(attachment, handler)//�ɴ������ͻص���CompletionHandler�ﵽ��Futureһ���Ŀ��
		process(future.get());
	}
	
	private static void process(AsynchronousSocketChannel asynchronousSocketChannel) {
		/*�õ�һ��SocketChannel��Ĳ���*/
	}
}
