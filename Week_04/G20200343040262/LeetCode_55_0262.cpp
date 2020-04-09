class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        int endreach = n - 1;//从后往前贪心
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] + i >= endreach) endreach = i;
        }
        return endreach == 0;
    }
};