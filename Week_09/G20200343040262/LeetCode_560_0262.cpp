/*
 * @lc app=leetcode.cn id=560 lang=cpp
 *
 * [560] 和为K的子数组
 */

// @lc code=start
/** pre[i] 为 [0..i] 里所有数的和
 * 建立哈希表，和为键，出现次数为对应的值，记录pre[i]出现的次数
 * 要找到和为k的连续子数组个数，只需统计有多少个和为pre[i] - k的pre[j]即可
 * */
class Solution {
public:
    int subarraySum(vector<int> &nums, int k) {
        unordered_map<int, int> mp;
        mp[0] = 1;
        int count = 0, pre = 0;
        for (auto &x : nums) {
            pre += x;
            if (mp.find(pre - x) != mp.end())
                count += mp[pre - k];
            mp[pre]++;
        }
        return count;
    }
};
// @lc code=end
