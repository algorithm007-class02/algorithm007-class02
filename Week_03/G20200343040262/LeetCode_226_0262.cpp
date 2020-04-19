/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 //1.recursion
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (root == NULL) return NULL;

        TreeNode* leftTree = root -> left;
        TreeNode* rightTree = root -> right;
        root -> left = invertTree(rightTree);
        root -> right = invertTree(leftTree);
        
        return root;
    }
};