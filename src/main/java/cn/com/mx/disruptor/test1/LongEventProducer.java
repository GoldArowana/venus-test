package cn.com.mx.disruptor.test1;

import com.lmax.disruptor.RingBuffer;

public class LongEventProducer {
	
	private final RingBuffer<LongEvent> ringBuffer;

	public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	/**
	 * onData用来发布事件，每调用一次就发布一次事件事件 它的参数会通过事件传递给消费者
	 * 
	 * @param message
	 */
	public void onData(String message) {
		// 可以把ringBuffer看做一个事件队列，那么next就是得到下面一个事件槽
		long sequence = ringBuffer.next();
		try {
			// 用上面的索引取出一个空的事件用于填充
			LongEvent event = ringBuffer.get(sequence);// for the sequence
			event.setMessage(message);
		} finally {
			// 发布事件
			ringBuffer.publish(sequence);
		}
	}
}