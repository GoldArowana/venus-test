package cn.com.mx.disruptor.test;

public class InitTest {
	
	public static void main(String[] args) throws Exception {
		DisruptorUtils.start();
		for(int i= 0;i<10;i++){
			Thread.sleep(100);
			DisruptorUtils.produce2("produce hello!"+i);
			System.out.println("produces finish :hello!"+i);
		}
		DisruptorUtils.shutdown();
	}
}
