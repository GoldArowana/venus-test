package cn.com.mx.javatzb.chapter05.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	private static final int THREAD_COUNT = 3;

	private final static CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(
			THREAD_COUNT, new Runnable() {
				public void run() {
					System.out.println("======>���ǵ��Σ����ε������׼������һ������!");
				}
			});

	public static void main(String[] args) throws InterruptedException,
			BrokenBarrierException {
		for (int i = 0; i < THREAD_COUNT; i++) {
			new Thread(String.valueOf(i)) {
				public void run() {
					try {
						System.out.println("�����̣߳�" + this.getName() + " ���Ǵﵽ���εص㣡");
						CYCLIC_BARRIER.await();
						System.out.println("�����̣߳�" + this.getName() + " ���ǿ�ʼ�ﳵ��");
						CYCLIC_BARRIER.await();
						System.out.println("�����̣߳�" + this.getName() + " ���ǿ�ʼ��ɽ��");
						CYCLIC_BARRIER.await();
						System.out.println("�����̣߳�" + this.getName() + " ���ǻر�����Ϣ��");
						CYCLIC_BARRIER.await();
						System.out.println("�����̣߳�" + this.getName() + " ���ǿ�ʼ�˳��ؼң�");
						CYCLIC_BARRIER.await();
						System.out.println("�����̣߳�" + this.getName() + " ���ǵ����ˣ�");
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
	}
}