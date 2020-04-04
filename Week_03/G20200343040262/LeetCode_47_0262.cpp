//backtracking
class Solution {
public:
    vector<vector<int>> res;
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<int> p;
        vector<bool> visited(nums.size(),false);
        backtrack(nums, p, visited);
        return res;
    }

    void backtrack(vector<int> nums, vector<int> p, vector<bool> visited) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        if (p.size() == n) {
            res.push_back(p);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;//剪枝重复排列
            p.push_back(nums[i]);
            visited[i] = true;
            backtrack(nums, p, visited);
            visited[i] = false;
            p.pop_back();
        }
    }
};