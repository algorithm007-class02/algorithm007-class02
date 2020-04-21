class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return max(linear_rob(vector<int>(nums.begin(), nums.end() - 1)), linear_rob(vector<int>(nums.begin() + 1, nums.end())));
    }
    int linear_rob(vector<int> nums) {
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