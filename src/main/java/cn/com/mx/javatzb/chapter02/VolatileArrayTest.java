package cn.com.mx.javatzb.chapter02;

class VolatileInteger {
	volatile int number;
}
public class VolatileArrayTest {

	/**
	 * �����У������ѭ����Σ����Ҫ����ʵ�ʵ�Ч����Ҫѭ���ܶ�β��ܿ���ʵ�ʵ�Ч��
	 * ��������Ч���Լ�CPUʹ�����ı仯
	 * @param args
	 */
	public static void main(String []args) {
		final VolatileInteger[]values = new VolatileInteger[10];
		for(int i = 0 ; i < 10 ; i++) {
			values[i] = new VolatileInteger();
		}
		for(int i = 0 ; i < 10 ; i++) {
			final int value = i;
			new Thread() {
				public void run() {
					for(int j = value ; j < 1000 ; j++) {
						values[value].number = value;
					}
				}
			}.start();
		}
	}
	
}
