/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 //递归
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        helper(res, root);
        return res;
    }

    void helper(vector<int>& res, TreeNode* root){
        if(!root) return;
        res.emplace_back(root->val);
        helper(res, root->left);
        helper(res, root->right);
    }
};

//迭代
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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> stk;
        TreeNode* cur = root;
        while(cur || !stk.empty()){
            if(!cur){
                cur = stk.top();
                stk.pop();
            }
            res.emplace_back(cur->val);
            if(cur->right) stk.push(cur->right);
            cur = cur->left;
        }
        return res;
    }
};