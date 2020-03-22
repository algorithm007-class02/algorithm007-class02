//lastNonZeroIndex指向从前向后最后一个不为0的元素，为遍历指针
class Solution{
    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[++lastNonZeroIndex] = nums[i];
                if (i != lastNonZeroIndex) {
                    nums[i] = 0;
                }
            }
        }
    }
}