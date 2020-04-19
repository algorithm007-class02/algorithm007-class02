/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 /*
思路：
递归终止条件
1.如果 p 和 q 都存在，则返回它们的公共祖先；
2.如果只存在一个，则返回存在的一个；
3.如果 p 和 q 都不存在，则返回NULL
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == NULL) return NULL;
        if (root == p || root == q) return root;
        TreeNode* left = lowestCommonAncestor(root -> left, p, q);
        TreeNode* right = lowestCommonAncestor(root -> right, p, q);
        if (left == NULL) return right;
        if (right == NULL) return left;
        if (left && right) return root;
        return NULL;
    }
};