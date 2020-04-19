/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// 递归
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> ret;
        preorder(root, ret);
        return ret;
    }

    void preorder(TreeNode* root, vector<int>& ret) {
        if ( root ==  NULL) return;

        ret.push_back(root->val);
        preorder(root->left, ret);
        preorder(root->right, ret);
    }
};


// 栈
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> ret;
        stack<TreeNode*> st;
        TreeNode* crr = root;;

        while(crr!= NULL || !st.empty()) {

            while(crr != NULL) {
                ret.push_back(crr->val);
                st.push(crr);
                crr = crr->left;
            }

            crr = st.top();
            crr = crr->right;
            st.pop();
        }

        return ret;
    }
};