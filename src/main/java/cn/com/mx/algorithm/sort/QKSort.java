package cn.com.mx.algorithm.sort;

/**
 * 快速排序
 * 
 * @author William
 */
public class QKSort {

	public static int[] quickSort(int[] array) {
		if (array != null) {
			return quickSort(array, 0, array.length - 1);
		}
		
		return null;
	}

	private static int[] quickSort(int[] array, int beg, int end) {
		if (beg >= end || array == null) {
			return null;
		}
		
		int p = partition(array, beg, end);
		quickSort(array, beg, p - 1);
		quickSort(array, p + 1, end);
		
		return array;
	}

	/**
	 * 找到分界点
	 * @param array
	 * @param beg
	 * @param end
	 * @return
	 */
	private static int partition(int[] array, int beg, int end) {
		int last = array[end];
		int i = beg - 1;
		
		for (int j = beg; j <= end - 1; j++) {
			if (array[j] <= last) {
				i++;
				if (i != j) {
					array[i] = array[i] ^ array[j];
					array[j] = array[i] ^ array[j];
					array[i] = array[i] ^ array[j];
				}
			}
		}
		
		if ((i + 1) != end) {
			array[i + 1] = array[i + 1] ^ array[end];
			array[end] = array[i + 1] ^ array[end];
			array[i + 1] = array[i + 1] ^ array[end];
		}
		
		return i + 1;
	}

}
