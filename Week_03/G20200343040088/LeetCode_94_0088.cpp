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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        inorder(root, res);
        return res;
    }

    void inorder(TreeNode* root, vector<int>& res) {
        if (root ==  NULL) return;

        inorder(root->left, res);
        res.push_back(root->val);
        inorder(root->right, res);
    }
};



// 栈
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ret;
        stack<TreeNode*> st;
        TreeNode* crr = root;

        while(crr != NULL || !st.empty()) {
            while(crr != NULL) {
                st.push(crr);
                crr = crr->left;
            }

            crr = st.top();
            ret.push_back(crr->val);
            st.pop();
            crr = crr->right;
        }

        return ret;
    }
};