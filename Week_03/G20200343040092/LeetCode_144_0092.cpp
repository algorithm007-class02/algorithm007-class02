class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        std::vector<int> res;
        Preorder(root, res);   
        return res;
    }

    void Preorder (TreeNode* node, std::vector<int> &res) {
        if (node == nullptr) {
            return;
        }
        res.push_back(node->val);
        Preorder(node->left, res);
        Preorder(node->right, res);
    }
};
