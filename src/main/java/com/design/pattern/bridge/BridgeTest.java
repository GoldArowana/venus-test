package com.design.pattern.bridge;

/**
 * 本代码出自博客：http://blog.csdn.net/zhangerqing 
 * email:xtfggef@gmail.com
 * 微博：http://weibo.com/xtfggef
 * @author egg
 * 
 */
public class BridgeTest {
	
	public static void main(String[] args) {
		
		Bridge bridge = new MyBridge();
		
		/*调用第一个对象*/
		Sourceable source1 = new SourceSub1();
		bridge.setSource(source1);
		bridge.method();
		
		/*调用第二个对象*/
		Sourceable source2 = new SourceSub2();
		bridge.setSource(source2);
		bridge.method();
	}
}
