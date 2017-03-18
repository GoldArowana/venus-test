package com.design.pattern.prototype;

/**
 * 本代码出自博客：http://blog.csdn.net/zhangerqing 
 * email:xtfggef@gmail.com
 * 微博：http://weibo.com/xtfggef
 * @author egg
 */
public class Test {

	public static void main(String[] args) {
		Prototype obj = new Prototype();
		
		try {
		Prototype obj2 = (Prototype) obj.clone();

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}

}
