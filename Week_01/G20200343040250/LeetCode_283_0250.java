class Solution {
    public void moveZeroes(int[] nums) {
        // 使用双指针解决
        // 一个指针一步一走，指向值为0位置
        // 另外一个指针指向不为0位置，与第一个指针指向的位置交换
        int first = 0;
        int second = 0;

        while (second < nums.length - 1) {
            if (nums[first] != 0) {
                first ++;
            }

             if (nums[++second] != 0) {
                    // 交换
                    swap(nums, first, second);
                }
        }
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}