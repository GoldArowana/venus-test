package cn.com.mx.javatzb.chapter05.tools;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

	public static void main(String []args) {
		final Exchanger <Integer>exchanger = new Exchanger<Integer>();
		for(int i = 0 ; i < 10 ; i++) {
			final Integer num = i;
			new Thread() {
				public void run() {
					System.out.println("�����̣߳�Thread_" + this.getName() + " �ҵ�����ǣ�" + num);
					try {
						Integer exchangeNum = exchanger.exchange(num);
						Thread.sleep(1000);
						System.out.println("�����̣߳�Thread_" + this.getName() + " ��������Ϊ��" + num + " , ����������Ϊ��" + exchangeNum);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
	}
}
