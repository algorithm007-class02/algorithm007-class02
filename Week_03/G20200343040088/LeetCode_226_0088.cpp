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
    TreeNode* invertTree(TreeNode* root) {
        if (root == NULL) return root;
        
        invert(root);
        return root;
    }

    void invert(TreeNode* root) {
        // 1. terminator
        if ( root -> left == NULL && root -> right == NULL) return;
        // 2. process
        TreeNode *temp = root->left;
        root->left = root->right;
        root->right = temp;

        if (root->left) invert(root->left);
        if (root->right) invert(root->right);
        // 3. drill down
        // 4. clear state
    }
};


class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (root == NULL) return root;

        TreeNode* right = invertTree(root->right);
        TreeNode* left = invertTree(root->left);

        root->left = right;
        root->right = left;
        return root;
    }

};
