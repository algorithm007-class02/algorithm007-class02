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
    void helper(TreeNode* root){
        if(!root) return;
        TreeNode* temp = root->right;
        root->right = root->left;
        root->left = temp;
        helper(root->left);
        helper(root->right);
    }
    TreeNode* invertTree(TreeNode* root) {
        helper(root);
        return root;
    }

};

//同样是传入一个TreeNode*  应该要能想到递归可以两个方法合在一起写的！！！