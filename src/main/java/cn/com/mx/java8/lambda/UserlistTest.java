package cn.com.mx.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
		System.out.println("==================");

		// array

		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		Arrays.stream(arr).forEach(value -> System.out.println(value));


	}

}
