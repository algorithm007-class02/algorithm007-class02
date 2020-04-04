class Solution {
    public int majorityElement(int[] nums) {
        int ret = nums[0];
        int count = 1;
        for (int num : nums) {
            if (num != ret) {
                count--;
                if (count == 0) {
                    count = 1;
                    ret = num;
                }
            } else {
                count++;
            }
        }
        return ret;
    }
}