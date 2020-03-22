class Solution {
    public int removeDuplicates(int[] nums) {
        // 使用双指针法解题
        // 第一个指针i指向第一个出现的不重复数据， 第二个指针j寻找下一个不重复的数据
        // 如果nums[i] == nums[j]则说明两个数据重复，第二个指针j++继续下一个不重复的数据
        // 如果nums[i] != nums[j] 说明是重复的数据，则将nums[j]值赋值给第一个指针的下一个nums[i+1]数据， 这时i++，继续寻找当前数据的不重复元素
        int i = 0;
        int j = 1;

        int size = 1;

        while (i < nums.length && j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[++i] = nums[j];
                size++;
            }
        }
        return size;
    }
}