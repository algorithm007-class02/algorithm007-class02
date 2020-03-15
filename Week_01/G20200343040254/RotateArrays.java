/**
 * 
 */
package week01;

/**
 * @author Jarod.xu
 *
 */
public class RotateArrays {
	/**
	 * brute + swap
	 * 
	 * @param nums
	 * @param k
	 */
	public void rotate_01(int[] nums, int k) {
		if (nums == null | nums.length <= 0)
			return;

		for (int i = 0; i < k; i++) {
			int last = nums[nums.length - 1];
			for (int j = 0; j < nums.length; j++) {
				int temp = nums[j];
				nums[j] = last;
				last = temp;
			}
		}
	}

	/**
	 * new + copy
	 * 
	 * @param nums
	 * @param k
	 */
	public void rotate_02(int[] nums, int k) {
		if (nums == null | nums.length <= 0)
			return;

		int[] a = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			a[(i + k) % nums.length] = nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = a[i];
		}
	}

	/**
	 * ring + swap
	 * 
	 * @param nums
	 * @param k
	 */
	public void rotate_03(int[] nums, int k) {
		if (nums == null | nums.length <= 0)
			return;

		k = k % nums.length;
		int count = 0;
		for (int start = 0; count < nums.length; start++) {
			int current = start;
			int prev = nums[start];
			do {
				int next = (current + k) % nums.length;
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				current = next;
				count++;
			} while (start != current);
		}
	}

	/**
	 * reverse
	 * 
	 * @param nums
	 * @param k
	 */
	public void rotate_04(int[] nums, int k) {
		if (nums == null | nums.length <= 0)
			return;

		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);// O(n)
		reverse(nums, 0, k - 1);// O(n)
		reverse(nums, k, nums.length - 1);// O(n)
	}

	public void reverse(int[] nums, int s, int e) {
		while (s < e) {
			int t = nums[s];
			nums[s] = nums[e];
			nums[e] = t;
			s++;
			e--;
		}
	}
}
