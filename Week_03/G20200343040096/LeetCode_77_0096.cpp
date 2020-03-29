class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> res;
        helper(1, n, k, vector<int>(), res);
        return res;
    }

    void helper(int begin, const int& n, const int& k, vector<int> temp, vector<vector<int>>& res){
        if(temp.size() == k){
            res.emplace_back(temp);
            return;
        }

        for(int i = begin; i <= n; ++i){
            temp.emplace_back(i);
            helper(i + 1, n, k, temp, res);
            temp.pop_back();
        }
    }
};
