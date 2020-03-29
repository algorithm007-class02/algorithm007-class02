/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
public:
    void helper(unordered_map<int, int> &mapBuf, int index, vector<int> &tmpValue, vector<vector<int>> &returnValue)
    {
        if(index >= mapBuf.size())
        {
            returnValue.push_back(tmpValue);
            return;
        }

        for(auto &x:mapBuf)
        {
            if(0 == x.second)
            {
                continue;
            }
            x.second--;

            tmpValue.push_back(x.first);
            helper(mapBuf, index + 1, tmpValue, returnValue);
            tmpValue.pop_back();
            x.second++;
        }

        return;
    }

    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> returnValue;
        vector<int> tmpValue;
        unordered_map<int, int> mapBuf;

        for(auto x:nums) mapBuf[x]++;

        helper(mapBuf, 0, tmpValue, returnValue);

        return returnValue;
    }
};