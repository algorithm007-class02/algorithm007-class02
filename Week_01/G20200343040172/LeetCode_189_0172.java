package Week_01.G20200343040172;

/**
 * LeetCode-189 旋转数组
 */
public class LeetCode_189_0172 {


    /**
     * 暴力解法，空间复杂度为O(1),时间复杂度则非常高，接近于O(N^2)
     * 虽然时间复杂度过高，但是也是一种思路
     *
     * 我本身是没有想过这种解法，下面的代码参见官方解法
     * @param nums
     * @param k
     */

    public void rotateSolution2(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 用另外一个数组保存旋转后的结果，然后将选择后的结果又拷贝回原数组
     * 时间复杂度应该是O(N),需要额外创建一个数组，空间复杂度应该为O(N)
     *
     * @param nums
     * @param k
     */
    public void rotateSolution1(int[] nums, int k) {
        int len = nums.length;
        int[] newArray = new int[len];
        for (int i = 0; i < nums.length; i++) {
            if (i + k <= nums.length - 1) {
                newArray[i + k] = nums[i];
            } else {
                int index = (k + i) % nums.length;
                newArray[index] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
    }
}

