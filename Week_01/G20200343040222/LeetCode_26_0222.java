/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 思路：
 * 用两个指针i，j 遍历遍历数组
 * 当i位置的树和j位置的树不等时，将j加1处理，
 * 否则将i位置的值置为0
 * 因为数组是给定排序的数组，所以删除后数组存在的元素顺序是相同且没有相同值
 *
 */
public class LeetCode_26_0222 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            } else {
                nums[i] = 0;
            }
        }
        return j + 1;

    }
}