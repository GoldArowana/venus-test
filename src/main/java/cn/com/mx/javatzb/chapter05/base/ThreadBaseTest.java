package cn.com.mx.javatzb.chapter05.base;

public class ThreadBaseTest {

	public static void main(String []args) {
		System.out.println("././...");
		new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
				System.out.println("���Ǳ��������̣߳���ִ����...");
			}
		}.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main process end...");
	}
}
