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
    vector<int> largestValues(TreeNode* root) {
        vector<int> ret;
        if (root == NULL) return ret;

        queue<TreeNode*> queueHelp;
        queueHelp.push(root);

        while(!queueHelp.empty()) {
            int size = queueHelp.size();

            int max = INT_MIN;
            for (int i = 0; i < size; i++) {
                TreeNode* temp = queueHelp.front();
                queueHelp.pop();
                if (temp->val > max) max = temp->val;

                if (temp->left) queueHelp.push(temp->left);
                if (temp->right) queueHelp.push(temp->right);
            }

            ret.push_back(max);
        }

        return ret;
    }
};