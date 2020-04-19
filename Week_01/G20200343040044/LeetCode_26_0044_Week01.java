//双指针
//数组完成排序后，放置两个指针i and j,i是慢指针，j是快指针。nums[i] = nums[j],就增加j以跳过重复项

class Solution {
    public int removeDuplicates(int[] nums)
{
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++)
    {
        if (nums[j] != nums[i])
        {
            i++;
            nums[i] = nums[j];
        }
    }
    return i + 1;
}
}