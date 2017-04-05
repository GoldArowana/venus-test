package com.design.pattern.adpter;

/**
 * ?????????????http://blog.csdn.net/zhangerqing 
 * email:xtfggef@gmail.com
 * ?????http://weibo.com/xtfggef
 * @author egg
 * 
 */
public class AdapterTest {

	public static void main(String[] args) {
		Source source = new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
	}
}
