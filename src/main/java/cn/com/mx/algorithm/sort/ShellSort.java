package cn.com.mx.algorithm.sort;

/**
 * ShellÅÅÐò
 * 
 * @author William
 */
public class ShellSort {

	public static int[] shellSort(int[] array) {
		if (array == null) {
			return null;
		}
		
		for (int i = array.length / 2; i > 2; i /= 2) {
			for (int j = 0; j < i; j++) {
				insertSort(array, j, i);
			}
		}

		insertSort(array, 0, 1);
		
		return array;
	}

	private static void insertSort(int[] array, int start, int inc) {
		for (int i = start + inc; i < array.length; i += inc) {
			for (int j = i; (j >= inc) && (array[j] < array[j - inc]); j -= inc) {
				swap(array, j, j - inc);
			}
		}
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
