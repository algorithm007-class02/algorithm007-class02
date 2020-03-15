/**
 * 移动零：
 * 给定一个数组nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
 */
class Solution {

    /**
     * 解法一：暴力解法
     * 遍历数组，遇到0就将其移至最后，其后的数据都向前移动一位
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int count = 0;//遍历数组次数
        for (int i = 0; count < nums.length; ) {
            //由于遇到0后会移动后面的数据向前一位，所以i不变（此时i已经是下个元素了）
            if (nums[i] == 0) {
                System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - i);
                nums[nums.length - 1] = 0;
            } else {//非0的话需要递增角标，来指向下个元素
                i++;
            }
            count++;//无论是否为0，都是一次遍历
        }
    }

    /**
     * 解法二：根据0的个数移动非0元素
     * 遍历数组，统计遇到0的个数zeroCount，遇到非0元素，就将该元素向前移动zeroCount位
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (zeroCount > 0) {
                nums[i - zeroCount] = nums[i];
                nums[i] = 0;
            }
        }
    }

    /**
     * 解法三：根据非零元素应存放位置来填充数组
     * 遍历数组，遇到非0元素，就将该元素放到非0元素指定的位置，遍历完元素后再将指定非0元素位置之后的数据都置为0
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void moveZeroes3(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int nonZero = 0;//非0元素从0位置开始填出
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nonZero != i) {
                    nums[nonZero] = nums[i];
                    nums[i] = 0;
                }
                nonZero++;
            }
        }
    }
}