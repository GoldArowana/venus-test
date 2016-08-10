package cn.com.mx.javatzb.chapter05.base;

import java.lang.Thread.UncaughtExceptionHandler;

class TestExceptionHandler implements UncaughtExceptionHandler {
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("�̳߳����쳣��");
		e.printStackTrace();
		System.out.printf("\n��ǰ�߳�ջ��");
		new Exception().printStackTrace();
	}
}
public class ExceptionHandlerTest {

	public static void main(String []args) {
		Thread t = new Thread() {
			public void run() {
				Integer.parseInt("ABC");
			}
		};
		t.setUncaughtExceptionHandler(new TestExceptionHandler());
		t.start();
	}
}
