// 72. 编辑距离
// https://leetcode-cn.com/problems/edit-distance/

// 解法1:暴力
// 时间: O()
// 空间: O()

// 解法2:递归DFS
// 时间: O(2^N)
// 空间: O(1)

// 解法3:递归DFS+记忆化
// 时间: O(M^N)
// 空间: O(N)

// 解法4:动态规划1
// 时间: O(N^2)
// 空间: O(N^2)
// 注意：min(A,B)：比较两个值的较小值，比较三个时需要比较两次
// **dp：指向指针的指针；new int* [size1+1]，new int[size2+1]的区别
class Solution {
public:
	int minDistance(string word1, string word2) {
		int size1 = word1.size();
		int size2 = word2.size();
		// int **dp = new int* [size1+1];
		// for (int i = 0; i<=size1; i++) dp[i] = new int[size2+1];
		vector<vector<int>> dp(size1+1, vector<int>(size2+1, 0));
		for (int i = 0; i<=size1; i++) dp[i][0] = i;
		for (int j = 0; j<=size2; j++) dp[0][j] = j;
		for (int i = 1; i <= size1; i++) {   // 从'j=1 i=1'开始比较，因为第一行‘i=0’和第一列‘j=0’都已经知道具体数值。
			for (int j = 1; j <= size2; j++) {
				if (word1[i-1] == word2[j-1]) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = min(min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
				}
			}
		}
		return dp[size1][size2];
	}
};


// 解法5:动态规划2
// 这个为最优解
// 时间: O(N^2)
// 空间: O(N)
// 注意：min(A,B)：比较两个值的较小值，比较三个时需要比较两次
// **dp：指向指针的指针；new int* [size1+1]，new int[size2+1]的区别
class Solution {
public:
	int minDistance(string word1, string word2) {
		int size1 = word1.size();
		int size2 = word2.size();
		int pre = 0;    //存储了原来的dp[i-1][j-1]
		// int **dp = new int* [size1+1];
		// for (int i = 0; i<=size1; i++) dp[i] = new int[size2+1];
		vector<int> dp(size2+1, 0);
		for (int j = 1; j<=size2; j++) dp[j] = j;
		for (int i = 1; i <= size1; i++) {   // 从'j=1 i=1'开始比较，因为第一行‘i=0’和第一列‘j=0’都已经知道具体数值。
			pre = dp[0];
			dp[0] = i;
			for (int j = 1; j <= size2; j++) {
				int tmp = dp[j];
				int d1 = dp[j-1];
				int d2 = dp[j];
				int d3 = pre;  // 原来的dp[i-1][j-1]
				if (word1[i-1] == word2[j-1]) {
					dp[j] = d3;  // 原来的dp[i-1][j-1]
				} else {
					dp[j] = min(min(d2, d3), d1)+ 1;
				}
				pre = tmp;
			}
		}
		return dp[size2];
	}
};