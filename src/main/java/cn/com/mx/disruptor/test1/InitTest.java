package cn.com.mx.disruptor.test1;

public class InitTest {
	
	public static void main(String[] args) throws InterruptedException {
		//LongEventProducer producer = DisruptorUtils.start();
		long start = System.currentTimeMillis();
		LongEventProducerWithTranslator producer = DisruptorUtils.start1();
		for (long l = 0; l < 100_000; l++) {
			//Thread.sleep(100);
			String message = "produces hello:" + l;
			producer.onData(message);
			System.out.println("produce finish:" + message);
		}
		long end = System.currentTimeMillis();
		System.out.println(end -start);

		DisruptorUtils.shutdown();
	}
}
