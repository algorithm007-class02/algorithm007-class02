//终极简化DP，原地
//a[i]: 从0到i天，且nums[i]必偷的最大值
//a[i] = max(a[i - 1] + 0, a[i - 2] + nums[i])；
//premax = a[i - 2], curmax = a[i - 1]. 即curmax = max(curmax, premax + nums[i]);
class Solution {
public:
    int rob(vector<int>& nums) {
        int len = nums.size();
        int premax = 0, curmax = 0;
        for (int i = 0; i < len; ++i) {
            int temp = curmax;
            curmax = max(curmax, premax + nums[i]);
            premax = temp;
        }
        return curmax;
    }
};