package week_03;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class lc_239_maxSlidingWindow {

	private void clean(ArrayDeque<Integer> q, int[] nums, int i, int k) {
		if (!q.isEmpty() && q.getFirst() == i - k) {
			q.removeFirst();
		}

		while (!q.isEmpty() && nums[i] > nums[q.getLast()]) {
			q.removeLast();
		}
	}

	public int[] maxSlidingWindow_01(int[] nums, int k) {

		if (nums == null || nums.length == 0 || k == 1)
			return nums;

		if (k <= 0)
			return new int[0];

		ArrayDeque<Integer> q = new ArrayDeque<>();

		int maxIndex = 0;
		for (int i = 0; i < k; i++) {
			clean(q, nums, i, k);
			q.addLast(i);

			if (nums[i] > nums[maxIndex]) {
				maxIndex = i;
			}
		}

		int[] out = new int[nums.length - k + 1];
		out[0] = nums[maxIndex];

		for (int i = k; i < nums.length; i++) {
			clean(q, nums, i, k);
			q.addLast(i);
			out[i - k + 1] = nums[q.getFirst()];
		}

		return out;
	}

	public int[] maxSlidingWindow_02(int[] nums, int k) {

		if (nums == null || nums.length == 0 || k == 1)
			return nums;

		if (k <= 0)
			return new int[0];

		int[] out = new int[nums.length - k + 1];

		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> (o2 - o1));

		for (int i = 0; i < nums.length; i++) {
			int s = i - k;
			if (s >= 0) {
				q.remove(nums[s]);
			}

			q.add(nums[i]);

			if (q.size() == k) {
				out[i - k + 1] = q.peek();
			}
		}

		return out;
	}

}
