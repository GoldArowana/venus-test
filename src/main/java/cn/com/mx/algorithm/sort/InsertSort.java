package cn.com.mx.algorithm.sort;

/**
 * ≤Â»Î≈≈–Ú
 * 
 * @author Q-WHai
 */
public class InsertSort {

	public static int[] insertSort(int[] array) {
		if (array == null) {
			return null;
		}
		
		for (int i = 1; i < array.length; i++) {
			for (int j = i; (j > 0) && (array[j] < array[j - 1]); j--) {
				swap(array, j, j - 1);
			}
		}
		
		return array;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
