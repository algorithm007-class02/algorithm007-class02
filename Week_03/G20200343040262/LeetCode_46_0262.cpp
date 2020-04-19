//Backtracking, 需要进一步学习代码
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        if (nums.size() == 0) return res;
        vector<bool> visit(nums.size(),false);
        vector<int> p;
        findpremute(res, nums, p, visit);
        return res;
    }
    void findpremute(vector<vector<int>>& res, vector<int>& nums, vector<int>& p, vector<bool>& visit) {
        int k = nums.size();
        if (p.size() == k) {
            res.push_back(p);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (!visit[i]) {
                p.push_back(nums[i]);
                visit[i] = true;//标记是否访问过
                findpremute(res, nums, p, visit);
                p.pop_back();
                visit[i] = false;//输出一个结果后，重新洗刷标记
            }
        }
    }
};