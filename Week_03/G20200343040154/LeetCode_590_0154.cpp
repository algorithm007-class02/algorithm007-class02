
// 590. N叉树的后序遍历

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
	vector<int> postorder(Node* root) {
		vector<int> ans;
		recuirce(ans, root);
		return ans;
	}
	void recuirce(vector<int>& ans, Node* node) {
		if (node) {
			for (auto child: node->children) {
				recuirce(ans, child);
			}
			ans.push_back(node->val);
		}
	}
};