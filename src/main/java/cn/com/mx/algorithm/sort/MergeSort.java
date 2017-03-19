package cn.com.mx.algorithm.sort;

/**
 * πÈ≤¢≈≈–Ú
 * 
 * @author William
 */
public class MergeSort {

	public static int[] mergeSort(int[] array) {
		if (array == null) {
			return null;
		}
		
		int[] temp = new int[array.length];
		return mergeSort(array, temp, 0, array.length - 1);
	}

	private static int[] mergeSort(int[] array, int[] temp, int l, int r) {
		int mid = (l + r) / 2;
		if (l == r) {
			return null;
		}
		mergeSort(array, temp, l, mid);
		mergeSort(array, temp, mid + 1, r);
		for (int i = l; i <= r; i++) {
			temp[i] = array[i];
		}
		int i1 = l;
		int i2 = mid + 1;
		for (int cur = l; cur <= r; cur++) {
			if (i1 == mid + 1) {
				array[cur] = temp[i2++];
			} else if (i2 > r) {
				array[cur] = temp[i1++];
			} else if (temp[i1] < temp[i2]) {
				array[cur] = temp[i1++];
			} else {
				array[cur] = temp[i2++];
			}
		}
		
		return array;
	}
}
