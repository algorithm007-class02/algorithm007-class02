class Solution {
    vector<string> ret;
public:
    vector<string> generateParenthesis(int n) {
        // 左括号， 右括号
        if (n <= 0) return ret;

        string str;
        dfs(0, 0, n, str);
        return ret;
    }

    void dfs(int left, int right, int max, string str) {
        if (left == max && right == max) {
            ret.push_back(str);
            return;
        }

        if ( left < max) { // 这里的判断逻辑一定要是小于
            string strtemp = str + '(';             // 这里不能用 str = str + '('， 如果这样会对下面的if产生影响
            dfs(left + 1, right, max, strtemp);
        }

        if (right < left) {
            string strtemp = str + ')';
            dfs(left, right + 1, max, strtemp);
        }
    }
};


// dfs 模板
// 