//backtrack
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        _generate(res, "", 0, 0, n);
        return res;
    }

    void _generate(vector<string>& res, string cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.push_back(cur);
            return;
        }
        if (open < max) _generate(res, cur + "(", open + 1, close, max);
        if (close < open) _generate(res, cur + ")", open, close + 1, max);
    }
};