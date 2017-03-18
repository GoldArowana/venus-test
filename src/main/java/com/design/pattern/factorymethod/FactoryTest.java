package com.design.pattern.factorymethod;

/**
 * 本代码出自博客：http://blog.csdn.net/zhangerqing 
 * email:xtfggef@gmail.com
 * 微博：http://weibo.com/xtfggef
 * @author egg
 */
public class FactoryTest {

	public static void main(String[] args) {	
		Sender sender = SendFactory.produceMail();
		sender.Send();
	}
}
