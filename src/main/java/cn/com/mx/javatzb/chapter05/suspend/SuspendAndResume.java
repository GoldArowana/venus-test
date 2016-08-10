package cn.com.mx.javatzb.chapter05.suspend;

/**
 * ע���ˣ�����һ������̲ģ���ҿ��Կ����߳����������û���ͷŵ�
 * @author xieyuooo
 *
 */
public class SuspendAndResume {

	private final static Object object =  new Object();

	static class ThreadA extends Thread {
		
		public void run() {
			synchronized(object) {
				System.out.println("start...");
				Thread.currentThread().suspend();
				System.out.println("thread end...");
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String []args) throws InterruptedException {
		ThreadA t1 = new ThreadA();
		ThreadA t2 = new ThreadA();
		t1.start();
		t2.start();
		Thread.sleep(1000);
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		t1.resume();
		t2.resume();
	}
}
