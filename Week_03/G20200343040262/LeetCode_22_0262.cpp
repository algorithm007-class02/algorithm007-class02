//1.recursion
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        recursion(0, 0, n, "", res);
        return res;
    }
private:
    void recursion(int left, int right, int n, string s, vector<string>& res) {
        if (left == n && right == n) res.push_back(s);
        if (left < n) recursion(left + 1, right, n, s + "(", res);
        if (right < n) recursion(left, right + 1, n, s + ")", res);
    }
};