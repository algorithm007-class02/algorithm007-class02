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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        helper(res, root);
        return res;
    }

    void helper(vector<int>& res, TreeNode* root){
        if(!root) return;
        helper(res, root->left);
        res.emplace_back(root->val);
        helper(res, root->right);
    }


};

//循环
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
        if(!root) return res;
        stack<TreeNode*> stk;
        while(root){
            stk.push(root);
            root = root->left;
        }
        while(!stk.empty()){
            TreeNode* node = stk.top();
            res.emplace_back(node->val);
            stk.pop();
            if(node->right) {
                node = node->right;
                while(node){
                    stk.push(node);
                    node= node->left;
                }
            }
        }
        return res;
    }
};