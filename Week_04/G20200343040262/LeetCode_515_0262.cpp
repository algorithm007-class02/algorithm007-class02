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
        deque<TreeNode*> q;
        vector<int> res;
        if (root == NULL) return res;
        q.push_back(root);
        while(!q.empty()) {
            int width = q.size();
            int level_max = q.front() -> val;
            for (int i = 0; i < width; i++) {
                TreeNode* node;
                node = q.front();
                level_max = max (level_max, node -> val);
                if (node -> left != NULL) q.push_back(node -> left);
                if (node -> right != NULL) q.push_back(node -> right);    
                q.pop_front();
            }
            res.push_back(level_max);
        }
        return res;
    }
};