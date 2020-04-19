/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 //1.recursion, max(left_depth, right_depth) + 1
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (!root) return 0;
        int left_depth = maxDepth(root -> left) + 1;
        int right_depth = maxDepth(root -> right) + 1;
        return left_depth > right_depth ? left_depth : right_depth;
    }
};