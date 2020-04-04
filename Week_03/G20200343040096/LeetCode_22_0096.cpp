class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        helper(res, 0, 0, n, "");
        return res;
    }

    void helper(vector<string>& res, int left, int right, int n, string str){
        if(left == n && right == n){
            res.emplace_back(str);
        }
        if(left < n) helper(res, left + 1, right, n, str + "(");
        if(right < left) helper(res, left, right + 1, n, str + ")");
    }
};

