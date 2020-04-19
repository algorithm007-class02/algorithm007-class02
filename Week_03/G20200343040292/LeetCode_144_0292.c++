/*递归
时间复杂度：O(N)
空间复杂度：O(N)*/
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        if (!root)
            return vector<int>();

        vector<int> res;
        res.push_back(root->val);
        if (root->left) {
            vector<int> tmp = preorderTraversal(root->left);
            res.insert(res.end(), tmp.begin(), tmp.end());
        }
        if (root->right) {
            vector<int> tmp = preorderTraversal(root->right);
            res.insert(res.end(), tmp.begin(), tmp.end());
        }
        return res;
    }
};

/*迭代法
时间复杂度：O(N)
空间复杂度：O(N)*/
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        vector<TreeNode*> stack;
        if (!root)
            return res;

        stack.push_back(root);
        while (!stack.empty()) {
            TreeNode* node = stack.back();
            stack.pop_back();
            res.push_back(node->val);
            if (node->right) 
                stack.push_back(node->right);
            if (node->left)
                stack.push_back(node->left);
        }
        return res;
    }
};