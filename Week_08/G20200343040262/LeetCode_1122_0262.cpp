/*
 * @lc app=leetcode.cn id=1122 lang=cpp
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
public:
    vector<int> relativeSortArray(vector<int> &arr1, vector<int> &arr2) {
        unordered_map<int, int> dic;
        for (auto n : arr1) {
            // 数据最大是1000，加上1001使得他们一定排在末尾
            dic[n] = 1001 + n;
        }
        for (int i = 0; i < arr2.size(); i++) {
            // 改写出现在arr2的数值的映射
            dic[arr2[i]] = i;
        }
        // lambda函数精简代码
        sort(arr1.begin(), arr1.end(), [&dic](const int &a, const int &b) { return dic[a] < dic[b]; });
        return arr1;
    }
};
// @lc code=end
