class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 1; int mark = nums[0];
        for (int i = 1; i< nums.length; i++)
        {
            if (nums[i] != mark)
            {
                nums[j] = nums[i];
                mark = nums[i];
                j++;
            }
        }
        return j;
    }
}