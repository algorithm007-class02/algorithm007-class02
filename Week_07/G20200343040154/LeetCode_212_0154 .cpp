// 212. 单词搜索 II
// https://leetcode-cn.com/problems/word-search-ii/

// 解法1: 暴力

// 解法2: Trie树+DFS
// 时间：O(N*M+(m*n)^2)
// 空间：O(N)
// fill_n() 的参数分别是指向被修改序列的第一个元素的正向迭代器、被修改元素的个数以及要被设置的值
// fill_n(next, 26, nullptr);
// 参考自国际站：https://leetcode.com/problems/word-search-ii/discuss/59868/C%2B%2B-48ms-56ms-simple-Trie-structure-68lines

class Trie {
	public:
	Trie* next[26];
	bool isEnd;

	Trie () {
		fill_n(next, 26, nullptr);
		isEnd = false;
	}

	~Trie () {
		for (int i = 0; i < 26; i++) {
			delete next[i];
		}
	}

	void insert(const string &word) {
		Trie* node = this;
		for (char c : word) {
			if (node->next[c-'a'] == nullptr) {
				node->next[c-'a'] = new Trie();
			}
			node = node->next[c-'a'];
		}
		node->isEnd = true;
	}
};

class Solution {
public:
	int m, n;
	vector<int> dx = {-1,1,0,0}; // 四联通 -> 注意越界要剪枝
	vector<int> dy = {0,0,-1,1};

	vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
		Trie* trie = new Trie();
		for (string word : words) {
			trie->insert(word);
		}
		m = board.size();
		n = board[0].size();

		vector<string> ans;
		string temp;
		for (int i = 0; i<m; i++) {
			for (int j=0; j<n; j++) {
				DFS(board, ans, temp, trie, i, j);
			}
		}
		return ans;
	}

	void DFS(vector<vector<char>>& board, vector<string> &ans, string temp, Trie *root, int i, int j) {
		if (i<0 || i>=m || j<0 || j>=n || board[i][j] == '@' || root == nullptr) return;
		if (root->next[board[i][j]-'a'] == nullptr) return;
		root = root->next[board[i][j]-'a'];
		char t = '@';
		swap(t, board[i][j]);
		temp.push_back(t);
		if (root->isEnd) {
			root->isEnd = false;
			ans.push_back(temp);
		}
		for (int k=0; k<4; k++) {
			DFS(board, ans, temp, root, i+dx[k], j+dy[k]);
		}
		// DFS(board, ans, temp, root, i, j + 1);
		// DFS(board, ans, temp, root, i + 1, j);
		// DFS(board, ans, temp, root, i - 1, j);
		// DFS(board, ans, temp, root, i, j - 1);
		swap(t, board[i][j]);
		temp.pop_back();
	}
};

// 1. words遍历 --> board search
// O(N*m*m*4^k)

// 2.Trie树
// a. all words --> trie 构建起 prefix
// b. board , DFS
// c. 遍历出来的值是否在Trie树中出现

// 时间复杂度: O(N*M+(m*n)^2). ???
