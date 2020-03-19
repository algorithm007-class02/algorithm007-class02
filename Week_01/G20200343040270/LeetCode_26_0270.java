/**
 * 删除排序数组中的重复项：
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
class Solution {
    /**
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 排序数组
     * @return 移除后数组的新长度
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            //如果i和j相等则不需要交换
            if (nums[i] != nums[j] && ++i != j) {
                nums[i] = nums[j];
            }
        }
        return i + 1;//i是角标，长度需+1
    }
}