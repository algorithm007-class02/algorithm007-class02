package week_03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class lc_347_topKFrequent {
	public List<Integer> topKFrequent(int[] nums, int k) {

		List<Integer> result = new LinkedList<Integer>();
		if (nums == null || nums.length == 0)
			return result;

		if (k <= 0)
			return result;

		Map<Integer, Integer> countMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
		}

		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> (countMap.get(o1) - countMap.get(o2)));

		for (int n : countMap.keySet()) {
			q.add(n);

			if (q.size() > k) {
				q.poll();
			}
		}

		while (!q.isEmpty()) {
			result.add(q.poll());
		}

		return result;
	}
}
