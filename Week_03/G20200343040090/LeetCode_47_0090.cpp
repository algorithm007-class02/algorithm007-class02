/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

class Solution {
public:
    void helper(unordered_map<int, int> &mapNums, int max, int index, vector<int> tmpValue, vector<vector<int>> &returnValue)
    {
        if(index >= max)
        {
            returnValue.push_back(tmpValue);
            return; 
        }

        for(auto &i : mapNums)
        {
            if(0 == i.second)
            {
                continue;
            }
            i.second--;
            
            vector<int> tmp = tmpValue;
            tmp.push_back(i.first);
            helper(mapNums, max, index + 1, tmp, returnValue);

            i.second++;
        }
        
        return;
    }

    vector<vector<int>> permuteUnique(vector<int>& nums) {
        unordered_map<int, int> mapNums;
        for(auto i: nums)
        {
            mapNums[i]++;
        }

        vector<vector<int>> returnValue;
        vector<int> tmpValue;

        helper(mapNums, nums.size(), 0, tmpValue, returnValue);

        return returnValue;
    }
};