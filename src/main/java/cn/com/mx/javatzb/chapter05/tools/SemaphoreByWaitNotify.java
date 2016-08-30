package cn.com.mx.javatzb.chapter05.tools;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreByWaitNotify {
	
	private final static int QUERY_MAX_LENGTH = 5;
	
	private final static int THREAD_COUNT = 20;
	
	private final static AtomicInteger NOW_CALL_COUNT = new AtomicInteger(0);
	
	private final static Object LOCK_OBJECT = new Object();

	public static void main(String[] args) {
		final Random radom = new Random();
		for (int i = 0; i < THREAD_COUNT; i++) {
			new Thread(String.valueOf(i)) {
				 public void run() {
					tryToLock();//���Ի�ȡ��ִ��Ȩ��
					System.out.println(this.getName() + "======�ҿ�ʼ�������ˣ�");
					try {
						Thread.sleep(100 + (radom.nextInt() & 3000));
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(this.getName() + "======���������ˣ�");
					tryToUnLock();//�ͷ���
				}
			}.start();
		}
	}
	
	private static void tryToUnLock() {
		NOW_CALL_COUNT.getAndDecrement();
		synchronized(LOCK_OBJECT) {
			LOCK_OBJECT.notify();
		}
	}
	
	private static void tryToLock() {
		int tryTimes = 0;
		int nowValue = NOW_CALL_COUNT.get(); 
		while(true) {
			if(nowValue < QUERY_MAX_LENGTH && NOW_CALL_COUNT.compareAndSet(nowValue, nowValue + 1)) {  
                break;//��ȡ����  
            }
			if(tryTimes % 3 == 0) {//����3�������ɹ�������
				waitForObjectNotify();
			}
			nowValue = NOW_CALL_COUNT.get();
			tryTimes++;
		}
	}

	private static void waitForObjectNotify() {
		synchronized(LOCK_OBJECT) {
			try {
				LOCK_OBJECT.wait(500);//���ȴ�500ms������
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
