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
    int minDepth(TreeNode* root) {
        if(!root) return 0;
        if(!root->left && !root->right) return 1;
        int res = INT_MAX;
        if(root->left) res = std::min(minDepth(root->left), res);
        if(root->right) res = std::min(minDepth(root->right), res);
        return res + 1;
    }
};