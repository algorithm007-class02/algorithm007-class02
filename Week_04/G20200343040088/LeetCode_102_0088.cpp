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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ret;
        if (root == NULL) return ret;

        queue<TreeNode*> queHelp;
        queHelp.push(root);

        while(!queHelp.empty()) {
            int size = queHelp.size();
            vector<int> vec;

            for (int i = 0; i < size; i++){
                TreeNode* temp = queHelp.front();
                queHelp.pop();
                vec.push_back(temp->val);

                if (temp->left) queHelp.push(temp->left);
                if (temp->right) queHelp.push(temp->right);
            }

            ret.push_back(vec);
        }
        
        return ret;
    }
};