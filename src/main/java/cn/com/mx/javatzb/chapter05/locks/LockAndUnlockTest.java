package cn.com.mx.javatzb.chapter05.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAndUnlockTest {
	
	private static int counter = 0;

	private final static Lock PUBLIC_LOCK = new ReentrantLock();
	
	static class ThreadTest extends Thread {
		public void run() {
			try {
				PUBLIC_LOCK.lock();
				//PUBLIC_LOCK.lock();//���������lock�����ֻ��һ��unlock�ͻ�������Ŷ
				counter++;
			}finally {
				PUBLIC_LOCK.unlock();
			}
		}
	}
	
	public static void main(String []args) throws InterruptedException {
		ThreadTest [] threads = new ThreadTest[100];
		for(int i = 0 ; i < 100 ; i++) {
			threads[i] = new ThreadTest();
			threads[i].start();
		}
		for(Thread thread : threads) {
			thread.join();
		}
		System.out.println(counter);
	}
}
