// 22. 括号生成
// https://leetcode-cn.com/problems/generate-parentheses/

// 解法：暴力、回溯、递归

// 计算公式为：初始值l=n，r=0. 当新增作左括号时l-1，r+1,当新增右括号时，l不变，r-1。当l=r=0时，判断合法，否则不符合剪枝。
class Solution {
public:
	void gns(string str, int l, int r, vector<string>& ans) {
		if (l==0 && r==0) ans.push_back(str);
		if (l>0) gns(str+"(", l-1, r+1, ans);
		if (r>0) gns(str+")", l, r-1, ans);
	}
	vector<string> generateParenthesis(int n) {
		vector<string> ans;
		gns("", n, 0, ans);
		return ans;
	}
};

// 计算公式为：初始值l=r=n,使用l>r进行判断是否合法，不符合就剪枝。
class Solution {
public:
	void gns(string str, int l, int r, vector<string>& ans) {
		if (l==0 && r==0) ans.push_back(str);
		if (l>r) return; 
		if (l>0) gns(str+"(", l-1, r, ans);
		if (r>0) gns(str+")", l, r-1, ans);
	}
	vector<string> generateParenthesis(int n) {
		vector<string> ans;
		gns("", n, n, ans);
		return ans;
	}
};