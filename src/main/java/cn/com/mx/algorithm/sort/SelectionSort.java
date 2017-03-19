package cn.com.mx.algorithm.sort;

/**
 * —°‘Ò≈≈–Ú
 * 
 * @author William
 */
public class SelectionSort {

	public static int[] selectionSort(int[] array) {
		if (array == null) {
			return null;
		}
		
		for (int i = 0; i < array.length; i++) {
			int lowIndex = i;
			for (int j = array.length - 1; j > i; j--) {
				if (array[j] < array[lowIndex]) {
					lowIndex = j;
				}
			}

			swap(array, i, lowIndex);
		}
		
		return array;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
