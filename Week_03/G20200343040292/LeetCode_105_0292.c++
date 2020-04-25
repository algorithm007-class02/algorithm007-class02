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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        pre_idx = 0;
        this->preorder = preorder;
        this->inorder = inorder;
        int index = 0;
        for (auto node : inorder) {
            idx_map.insert(make_pair(node, index++));
        }
        return MakeTree(0, preorder.size());
    }

    TreeNode* MakeTree(int left, int right) {
        if (left == right) 
            return NULL;
        
        int root_val = preorder[pre_idx];
        TreeNode* node = new TreeNode(root_val);
        pre_idx++;
        int inorder_index = idx_map[root_val];

        node->left = MakeTree(left, inorder_index);
        node->right = MakeTree(inorder_index + 1, right);
        return node;
    }

    int pre_idx;
    vector<int> preorder;
    vector<int> inorder;
    unordered_map<int, int> idx_map; 
};