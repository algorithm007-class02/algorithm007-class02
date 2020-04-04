/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 //BFS,iteration
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        deque<TreeNode*> q;
        vector<vector<int>> res;
        if (root == NULL) return res;
        q.push_back(root);
        while(!q.empty()) {
            int width = q.size();
            vector<int> sub_res;
            for (int i = 0; i < width; i++) {
                TreeNode* node;
                node = q.front();
                sub_res.push_back(node -> val);
                if (node -> left != NULL) q.push_back(node -> left);
                if (node -> right != NULL) q.push_back(node -> right);    
                q.pop_front();
            }
            res.push_back(sub_res);
            sub_res.clear();
        }
        return res;
    }
};