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
        if (preorder.empty()) return NULL;

        for (int i = 0; i < inorder.size(); i++) {
            mp.insert(make_pair(inorder[i], i));
        }

        return helper(0, 0, inorder.size() - 1, preorder);
    }

    TreeNode* helper(int preStart, int inStart, int inEnd, vector<int>& preorder) {
        if ( inStart > inEnd || preStart > preorder.size() - 1 ) return NULL;

        TreeNode* root = new TreeNode(preorder[preStart]);
        int index = mp[root->val];

        root->left = helper(preStart + 1, inStart, index - 1, preorder);
        root->right = helper(preStart + index - inStart + 1, index + 1, inEnd, preorder );
        return root;
    }

    map<int, int> mp;
};