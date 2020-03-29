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
 //Notice:叶子节点是指没有子节点的节点,注意判断
class Solution {
public:
    int minDepth(TreeNode* root) {
        if (root == NULL) return 0;
        if (root -> left != NULL && root ->right != NULL) return min(minDepth(root -> left), minDepth(root -> right)) + 1;
        return minDepth(root -> left) + minDepth(root -> right) + 1;
    }
};