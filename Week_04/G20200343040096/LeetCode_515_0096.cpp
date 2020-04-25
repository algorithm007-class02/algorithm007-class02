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
      vector<int> res;
      if(!root) return res;
      queue<TreeNode*> q;
      q.push(root);
      while(!q.empty()){
        int size = q.size();
        int max = INT_MIN;
        for(int i = 0; i < size; ++i){
          TreeNode* node = q.front();
          q.pop();
          max = std::max(max, node->val);
          if(node->left) q.push(node->left);
          if(node->right) q.push(node->right);
        }
        res.emplace_back(max);
      }

      return res;
    }
};
