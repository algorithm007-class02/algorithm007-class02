
// 77. 组合

class Solution {
public:
	vector<vector<int>> combine(int n, int k) {
		vector<vector<int>> ans;
		vector<int> b(k,0);
		int i = 0;
		while (i >= 0) {
			b[i]++;
			if (b[i] > n) {
				i--;
			} else if (i == k - 1) {
				ans.push_back(b);
			} else {
				i++;
				b[i] = b[i - 1];
			}
		}
		return ans;
	}
};
