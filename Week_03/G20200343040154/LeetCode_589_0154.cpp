
// 589. N叉树的前序遍历

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

// 1.递归法
class Solution {
public:
	vector<int> preorder(Node* root) {
		vector<int> ans;
		preorderTraverse(ans, root);
		return ans;
	}
	void preorderTraverse(vector<int>& ans, Node* node) {
		if (node) {
			ans.push_back(node->val);
			for (auto child: node->children) {
				preorderTraverse(ans, child);
			}
		}
	}
};