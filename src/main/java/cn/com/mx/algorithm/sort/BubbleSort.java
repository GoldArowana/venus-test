package cn.com.mx.algorithm.sort;

/**
 * Ã°ÅİÅÅĞò
 * 
 * @author William
 */
public class BubbleSort {
	
	public static int[] bubbleSort(int[] array) {
		if (array == null) {
			return null;
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					array[i] = array[i] + array[j];
					array[j] = array[i] - array[j];
					array[i] = array[i] - array[j];
				}
			}
		}
		
		return array;
	}
}
