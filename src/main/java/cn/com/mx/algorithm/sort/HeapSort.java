package cn.com.mx.algorithm.sort;

/**
 * ∂—≈≈–Ú
 * 
 * @author William
 */
public class HeapSort {

	public static int[] heapSort(int[] array) {
		if (array == null) {
			return null;
		}
		MaxHeap h = new MaxHeap();
		h.init(array);
		
		for (int i = 0; i < array.length; i++) {
			h.remove();
		}
		
		System.arraycopy(h.queue, 1, array, 0, array.length);
		
		return array;
	}

	private static class MaxHeap {

		void init(int[] data) {
			this.queue = new int[data.length + 1];
			for (int i = 0; i < data.length; i++) {
				queue[++size] = data[i];
				fixUp(size);
			}
		}

		private int size = 0;

		private int[] queue;

		public int get() {
			return queue[1];
		}

		public void remove() {
			SortUtils.swap(queue, 1, size--);
			fixDown(1);
		}

		// fixdown
		private void fixDown(int k) {
			int j;
			while ((j = k << 1) <= size) {
				if (j < size && queue[j] < queue[j + 1]) {
					j++;
				}
				
				// ≤ª”√Ωªªª
				if (queue[k] > queue[j]) {
					break;
				}
				
				SortUtils.swap(queue, j, k);
				k = j;
			}
		}

		private void fixUp(int k) {
			while (k > 1) {
				int j = k >> 1;
				if (queue[j] > queue[k]) {
					break;
				}
				
				SortUtils.swap(queue, j, k);
				k = j;
			}
		}

	}
}
