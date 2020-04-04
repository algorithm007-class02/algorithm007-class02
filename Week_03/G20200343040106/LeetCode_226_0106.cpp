class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if(root==nullptr)
            return nullptr;
        swap(root->left,root->right);
        invertTree(root->right);
        invertTree(root->left);
        return root;
    }
};
