package cn.com.mx.java8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangchangye on 2016/12/1.
 */
public class UserlistTest {
	public static void main(String[] args) {
		List<User> list = new ArrayList<>();
		list.add(new User(1,"金神1"));
		list.add(new User(2,"谨慎2"));
		list.add(new User(3,"谨慎3"));
		list.stream().sorted(Comparator.comparing(User::getAge));
		System.out.println(list);
	}

}
