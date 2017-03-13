package cn.com.mx.disruptor.test;

import com.lmax.disruptor.EventHandler;
/**
 * 3.定义事件处理的具体实现
 * 通过实现接口 com.lmax.disruptor.EventHandler<T> 定义事件处理的具体实现。
 * @author totyuZWL
 *
 */
public class LongEventHandler implements EventHandler<LongEvent> {
	public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception{
		Thread.sleep(2000);
		System.out.println("consums: " + event.getMessage());
	}
}
