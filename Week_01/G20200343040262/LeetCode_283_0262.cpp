/*
LeetCode
（移动零）题目283描述：
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
*/
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int i = 0;
        int j;
        for (j = 0 ; i < nums.size(); i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        //i此时在数组末位的后一位，j此时在数组末位非零数的后一位
        while(j < i) { 
            nums[j] = 0;
            j++;
        }
    }
};