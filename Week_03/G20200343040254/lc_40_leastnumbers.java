package week_03;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lc_40_leastnumbers {

	/**
	 * N logn
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public int[] getLeastNumbers_01(int[] arr, int k) {
		if (arr == null || arr.length == 0 || arr.length < k)
			return arr;

		if (k <= 0)
			return new int[0];

		Arrays.sort(arr);

		int[] result = new int[k];

		for (int i = 0; i < result.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}

	/**
	 * N logk
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public int[] getLeastNumbers_02(int[] arr, int k) {

		if (arr == null || arr.length == 0 || arr.length < k)
			return arr;

		if (k <= 0)
			return new int[0];

		PriorityQueue<Integer> heap = new PriorityQueue<>(k);

		for (int i = 0; i < arr.length; i++) {
			heap.add(arr[i]);
		}

		int[] result = new int[k];

		for (int i = 0; i < k; i++) {
			result[i] = heap.poll();
		}
		return result;
	}

	public int[] getLeastNumbers_03(int[] arr, int k) {

		if (arr == null || arr.length == 0 || arr.length < k)
			return arr;

		if (k <= 0)
			return new int[0];

		PriorityQueue<Integer> heap = new PriorityQueue<>(k, (n1, n2) -> Integer.compare(n2, n1));

		for (int i = 0; i < arr.length; i++) {

			if (heap.size() < k) {
				heap.add(arr[i]);
			} else {
				if (arr[i] < heap.peek()) {
					heap.remove();
					heap.add(arr[i]);
				}
			}
		}

		int[] result = new int[heap.size()];

		int i = 0;
		while (!heap.isEmpty()) {
			result[i++] = heap.poll();
		}

		return result;
	}

}
