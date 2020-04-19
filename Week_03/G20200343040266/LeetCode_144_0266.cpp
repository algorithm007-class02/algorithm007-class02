class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> ans;
        stack<TreeNode*> stk;
        if (root==NULL) return ans;
        stk.push(root);
        while (!stk.empty()){
            root=stk.top();stk.pop();
            ans.push_back(root->val);
            if (root->right) {stk.push(root->right);}
            if (root->left) {stk.push(root->left);}
        }
        return ans;
    }
};