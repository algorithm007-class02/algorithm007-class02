/**
 * 
 */
package week01;

/**
 * @author Jarod.xu
 *
 */
public class RemoveDuplicates {
	public int removeDuplicates_01(int[] nums) {
		if (nums == null || nums.length <= 0)
			return 0;

		int c = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[c] != nums[j]) {
				c++;
				nums[c] = nums[j];
			}
		}
		return c + 1;
	}

	public int removeDuplicates_02(int[] nums) {
		if (nums == null || nums.length <= 0)
			return 0;

		int p = 0, a = 1;

		while (a < nums.length) {
			if (nums[p] != nums[a]) {
				p++;
				if (a > p) {
					nums[p] = nums[a];
				}
			}
			a++;
		}

		return p + 1;
	}
}
