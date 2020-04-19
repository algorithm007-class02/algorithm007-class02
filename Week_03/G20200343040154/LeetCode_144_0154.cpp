
// 144. 二叉树的前序遍历

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

// 1. 递归法 时间：O(N)  空间O(N)
// 栈
 class Solution {
 public:
     vector<int> ans;
     vector<int> preorderTraversal(TreeNode* root) {
         if (root) {
             ans.push_back(root->val);
             if (root->left) preorderTraversal(root->left);
             if (root->right) preorderTraversal(root->right);
         }
         return ans;
     }
 };

 // 2.迭代法 时间O(N) 空间O(N)
 class Solution {
 public:
     vector<int> preorderTraversal(TreeNode* root) {
         stack<TreeNode*> sta;
         vector<int> ans;
         while(root || sta.size()) {
             while(root) {
                 sta.push(root);
                 ans.push_back(root->val);
                 root = root -> left;   // 1.遍历所有左节点
             }
             root = sta.top();
             sta.pop();
             root = root->right;
         }
         return ans;
     }
 };

// 3。迭代法 时间O(N) 空间O(N)
// 栈
class Solution {
public:
	vector<int> preorderTraversal(TreeNode* root) {
		vector<int> ans;
		if (!root) return ans;
		TreeNode *temp = root;
		stack<TreeNode*> s;
		s.push(temp);
		while(s.size()) {
			temp = s.top();
			s.pop();
			ans.push_back(temp->val);
			if (temp->right) s.push(temp->right); // 右节点在左节点之前入栈
			if (temp->left) s.push(temp->left);
		}
		return ans;
	}
};