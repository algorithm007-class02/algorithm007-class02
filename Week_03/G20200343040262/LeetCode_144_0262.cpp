/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 //思路2：迭代法，根左右，深度优先遍历，DFS
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root) {
            stack<TreeNode*> S;
            S.push(root);
            while (!S.empty()) {
                TreeNode* node = S.top();
                res.push_back(node -> val);
                S.pop();
                if (node -> right) S.push(node -> right);
                if (node -> left) S.push(node -> left);
            }
        }
        return res;
    }
};