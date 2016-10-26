package cn.com.mx.simpletest.list;

import java.util.Arrays;
import java.util.List;

public class AsListDemo {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		int[] array  = {1,2,3,4};
		List asList = Arrays.asList(array);
		int[] as_int= (int[])asList.get(0);
		for (int i : as_int) {
			System.out.print(i);
		}
		System.out.println();
		
		Integer[] array2 = {1,2,3,4,5,6};
		List<Integer> asList2 = Arrays.asList(array2);
		for (Integer integer : asList2) {
			System.out.println(integer);
		}
	}
}
