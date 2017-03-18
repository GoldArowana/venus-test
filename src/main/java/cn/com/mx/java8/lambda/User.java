package cn.com.mx.java8.lambda;

import lombok.Data;

/**
 * Created by wangchangye on 2016/12/1.
 */
@Data
public class User {
	private int age;
	private String name;
	public User(int age,String name){
		this.age=age;
		this.name=name;
	}
}
