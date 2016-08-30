package cn.com.mx.javatzb.chapter05.tools;

import java.util.concurrent.Phaser;

/**
 * �˴�����Ҫ��JDK 1.7���ϵİ汾����
 * @author xieyuooo
 *
 */
public class PhaserTest {

	private final static int COUNTER = 5;
	
	public static void main(String []args) throws InterruptedException {
		final Phaser phaser = new Phaser(COUNTER);
		for(int i = 0 ; i < COUNTER; i++) {
			final int num = i;
			Thread t = new Thread() {
				public void run() {
					System.out.println("��ǰ�̱߳��:" + num + " ׼����ʼִ�� \t" + System.currentTimeMillis());
					phaser.arriveAndAwaitAdvance();
					System.out.println("ִ���б�:" + num + " ��ʼִ�� \t" + System.currentTimeMillis());
					try {
						Thread.sleep(this.hashCode() & 2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					phaser.arriveAndDeregister();
					//phaser.arriveAndDeregister();//����ξͻ�������
					System.out.println("�̣߳�" + num + " ִ����� \t" + System.currentTimeMillis());
				}
			};
			Thread.sleep(1234);
			System.out.println("δ��arriveAndAwaitAdvance����" + phaser.getUnarrivedParties());
			t.start();
		}
		System.out.println("ע���ܸ���" + phaser.getRegisteredParties());
		while(!phaser.isTerminated()) {
			System.out.println("�ﵽ����" + phaser.getRegisteredParties() + "\t" + System.currentTimeMillis());
			Thread.sleep(20);
		}
		System.out.println("end .....");
	}
}
