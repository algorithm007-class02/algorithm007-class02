/**
 * 旋转数组：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 */
class Solution {
    /**
     * 解法一：暴力解法，移动k次，每次整个数组的元素都向右移动1位
     * 时间复杂度：O(k*n)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     * @param k    数组中的元素向右移动 k 个位置，k > 0
     */
    public void rotate(int[] nums, int k) {
        //checkValidities
        if (nums == null || nums.length == 0 || k <= 0) return;
        k = k % nums.length;//如果k大于数组长度，那整数倍的移动就是原数组，故数组长度取余
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];//记录最后一位元素
            for (int j = nums.length - 1; j > 0; j--) {//将前n-1个元素向后移动一位
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;//将最后一位元素赋值给第一位
        }
    }

    /**
     * 解法二：数组三次反序
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return;
        k = k % nums.length;
        if (k == 0) return;//移动数组长度整数倍，提前结束
        //整个数组反序
        this.reverse(nums, 0, nums.length - 1);
        //移动k位的前半部分反序（不包含k）
        this.reverse(nums, 0, k - 1);
        //移动k位的后半部分反序（包含k）
        this.reverse(nums, k, nums.length - 1);

    }

    /**
     * 解法三：
     * 直接将元素移动到它需要移动到的位置，由于每个元素都要移动，所以需要移动n次
     * 从0位置开始移动，再次回到开始位置，会有两种情况
     * 1.移动了n次，即数组已完成旋转。
     * 2.未完成n次移动，说明移动过程出现了循环，需要将开始位置递增1个，循环重复移动过程，直至再次回到
     * 开始位置并且移动了n次。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate3(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return;
        k = k % nums.length;
        int count = 0;//用于统计移动次数
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int temp = nums[start];//临时保存待移动元素
            do {
                int next = (current + k) % nums.length;
                current = next;
                //将待移动元素放置到需要移动到的位置（假如该位置元素为A），并更新待移动元素为A
                int cur = nums[next];
                nums[next] = temp;
                temp = cur;
                count++;
            } while (start != current);
        }
    }

    /**
     * 将数组中指定数据段反序
     * 对称交换
     * @param nums  数组
     * @param start 数据开始角标
     * @param end   数据结束角标
     */
    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            this.swap(nums, i, j);
        }
    }

    /**
     * 交换元素
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}