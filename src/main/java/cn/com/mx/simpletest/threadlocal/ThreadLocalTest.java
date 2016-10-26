package cn.com.mx.simpletest.threadlocal;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class ThreadLocalTest {
	
	private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();
	
	public static void setStartTime(long timeMillis) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startTime", timeMillis);
		threadLocal.set(paramMap);
	}
	public static void setEndTime(long timeMillis) {
		long costTime = timeMillis - (long) threadLocal.get().get("startTime");
		threadLocal.get().put("costTime", costTime);
		threadLocal.get().put("endTime", timeMillis);
	}
	
	public static String toString(boolean isDelete) {
		String rtnValue =  JSONObject.toJSONString(threadLocal.get());
		if (isDelete) {
			threadLocal.remove();
		}
		return rtnValue;
	}
	
	public static void main(String[] args) {
		ThreadLocalTest.setStartTime(System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ThreadLocalTest.setEndTime(System.currentTimeMillis());
		Object startTime = ThreadLocalTest.threadLocal.get().get("startTime");
		System.out.println("startTime:" + startTime);
		Object endTime = ThreadLocalTest.threadLocal.get().get("endTime");
		System.out.println("endTime:" + endTime);
		String val = ThreadLocalTest.toString(false);
		System.out.println(val);
	}
		
	
	
}//end of class
