//子序列和若<0，则前面已累计的子序和对后续子序和无丝毫帮助
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res = nums[0];
        int sub_sum = 0;
        for (int num : nums) {
            if (sub_sum > 0) sub_sum += num;
            else sub_sum = num;
            res = max(res, sub_sum);
        }
        return res;
    }
};