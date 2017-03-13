package cn.com.mx.disruptor.test1;

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent> {
	@Override
	public void onEvent(LongEvent longEvent, long l, boolean b)
			throws Exception {
		//Thread.sleep(100);
		System.out.println("consums finish:"+longEvent.getMessage());
	}
}