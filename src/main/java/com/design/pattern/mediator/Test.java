package com.design.pattern.mediator;

/**
 * 本代码出自博客：http://blog.csdn.net/zhangerqing 
 * email:xtfggef@gmail.com
 * 微博：http://weibo.com/xtfggef
 * @author egg
 */
public class Test {

	public static void main(String[] args) {
		Mediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.workAll();
	}
}
