class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        recursion(nums.size(), nums, res, 0);
        return res;
    }

    void recursion(int n, vector<int> nums, vector<vector<int>>& output, int first) {
        if (n == first) {
            output.push_back(nums);
        }

        for (int i = first; i < n; i++) {
            swap(nums[i], nums[first]);
            recursion(n, nums, output, first + 1);
            swap(nums[i], nums[first]);
        }
    }
};