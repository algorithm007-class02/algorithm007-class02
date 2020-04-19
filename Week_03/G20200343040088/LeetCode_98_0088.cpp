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
    bool isValidBST(TreeNode* root) {
        if (root == NULL) return true;
        if (root->left == NULL && root->right == NULL) return true;

        bool bIsvalid = true;
        inorder(root, bIsvalid);    

        return bIsvalid;
    }

    void inorder(TreeNode* root, bool& bIsvalid) {
        if (root == NULL || !bIsvalid) return;

        inorder(root->left, bIsvalid);

        if (!bIsvalid) return;

        if (st.empty()) {
            st.push(root->val);
        } else {
            int top = st.top();
            bIsvalid = top < root-> val;
            st.pop();
            st.push(root->val);
        }

        inorder(root->right, bIsvalid);
    }

private:
    stack<int> st;




};