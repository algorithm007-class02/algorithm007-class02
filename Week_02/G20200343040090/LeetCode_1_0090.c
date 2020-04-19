/*
1. 两数之和
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

*/

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> returnValue;
        if(1 >= nums.size())
        {
            return returnValue;
        }

        map<int, int> mapTaget;

        for(int i = 0; i < nums.size(); i++)
        {
            mapTaget[nums[i]] = i;
        }

        for(int i = 0; i < nums.size(); i++)
        {
            if(mapTaget.end() != mapTaget.find(target - nums[i]))
            {
                if(i == mapTaget.find(target - nums[i])->second)
                {
                    continue;//如果是自己则跳过
                }
                
                returnValue.push_back(i);
                returnValue.push_back(mapTaget.find(target - nums[i])->second);

                return returnValue;/*题目里说明只有一个答案，找到就返回*/
            }
        }

        return returnValue;
    }
};