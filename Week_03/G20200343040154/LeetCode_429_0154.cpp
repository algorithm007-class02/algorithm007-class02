
// 429. N叉树的层序遍历

/*
// Definition for a Node.
class Node {
public:
	int val;
	vector<Node*> children;

	Node() {}

	Node(int _val) {
		val = _val;
	}

	Node(int _val, vector<Node*> _children) {
		val = _val;
		children = _children;
	}
};
*/

// 1. DFS 解法 O(N) O(logN)
// 基于递归 => 使用堆栈 => DFS算法
class Solution {
public:
	vector<vector<int>> levelOrder(Node* root) {
		vector<vector<int>> ans;
		DFS(root, 0, ans);
		return ans;
	}
	void DFS(Node* root, int depth, vector<vector<int>>& ans) {
		if (!root) return;
		while(ans.size() == depth) ans.resize(depth+1);
		ans[depth].push_back(root->val);       // 对应到二维数组的第一维的下标，与层级depth大小相同
		for (Node* node : root->children) {
			if (node) DFS(node, depth+1, ans);
		}
	}
};


// 2. BFS 解法 O(N) O(N)
// 基于迭代 => 使用队列 => BFS算法
class Solution {
public:
	vector<vector<int>> levelOrder(Node* root) {
		return BFS(root);
	}
	vector<vector<int>> BFS(Node* root) {
		if (!root) return {};
		vector<vector<int>> ans;
		vector<Node*> curr,next;
		curr.push_back(root);
		while(!curr.empty()) {
			ans.push_back({});
			for (Node* node : curr) {
				if (node) ans.back().push_back(node->val);
				for (Node* child : node->children) {
					if (child) next.push_back(child);
				}
			}
			curr.swap(next);
			next.clear();
		}

		return ans;
	}
};


// 3. BFS 解法 O(N) O(N)
// queue & stack 使用队列
class Solution {
public:
	vector<vector<int>> levelOrder(Node* root) {
		if (!root) return {};
		vector<vector<int>> ans;
		queue<Node*> q;
		q.push(root);
		while(!q.empty()) {
			int size = q.size();
			vector<int> curLevel;   // 值为int型的数组，而不是Node*
			for (int i=0; i<size; i++) { // 对当前层curLevel的每个Node进行遍历
				Node* tmp = q.front();
				q.pop();
				curLevel.push_back(tmp->val);    // 对Node进行值存储
				for (auto node: tmp->children) { // 对Node进行字节点进行遍历入queue
					if (node) q.push(node);
				}
			}
			ans.push_back(curLevel);
		}

		return ans;
	}  
};