// 547. 朋友圈
// https://leetcode-cn.com/problems/friend-circles/


// 解法1: DFS
// --

// 解法2: 并查集 (模版版)
// 时间：O(N^2)
// 空间：O(N)

class Solution {
	int parent[201]; // 最多200个

private:
	void makeSet(int n) {
		for (int i=0; i<n; i++) {
			parent[i] = i;
		}
	}

	int find(int p) {
		while(parent[p] != p) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}

	void unionSet(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) return;
		parent[rootQ] = rootP;
	}

public:
	int findCircleNum(vector<vector<int>>& M) {
		if (M.empty()) return 0;
		int n = M.size(), groups=0;
		// 第一步：创建并查集本身（套用自身函数）
		makeSet(n);

		// 第二步：遍历二维数组，合并i、j
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				if (M[i][j] == 1) {
					unionSet(i,j);
				}
			}
		}

		// 第三步：遍历所有结点，得到根parent的个数 - 注意判重
		// i == parent[i] => 即i为根parent
		for (int i =0; i< n; i++) {
			if (i == parent[i]) {
				groups++;
			}
		}

		return groups;
	}
};

// 解法3: 并查集 （另一种写法）

class Solution {
public:
	int findCircleNum(vector<vector<int>>& M) {
		if(M.empty()) return 0;
		int n = M.size();
		// 初始化总数为n,即每个人是一个parent
		int groups = n;

		// 第一步：创建并查集本身
		vector<int> parent(n, 0);
		for (int i=0; i<n; i++) parent[i] = i;

		// 第二步：遍历二维数组，合并i、j
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				if (M[i][j]) {
					int p1 = find(i, parent);
					int p2 = find(j, parent);
					if (p1 != p2) {
						parent[p1] = p2;
						// 第三步：遍历有多少个根parent
						groups--;
					}
				}
			}
		}
		return groups;
	}

	int find(int n, vector<int> &parent) {
		while(n != parent[n]) {
			parent[n] = parent[parent[n]];
			n = parent[n];
		}
		return n;
		// return parent[n] == n ? n : find(parent[n], parent);
	}
};
