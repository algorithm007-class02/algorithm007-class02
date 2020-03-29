class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        helper(0, nums);
        return vecRes;
    }

    void helper(int level, vector<int> nums) {
        if (nums.size() == level) {
            vecRes.push_back(nums);
            return;
        }

        for ( int i = level; i < nums.size(); i++) {
            swap(nums[i], nums[level]);
            helper(level+1, nums);
            swap(nums[level], nums[i]);
        }
    }

    vector<vector<int>> vecRes;
};