/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
};

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode *root) {
        vector<vector<int>> res;
        queue<TreeNode *> q;
        if (root == nullptr)
            return res;
        q.push(root);
        while (!q.empty()) {
            int width = q.size();
            vector<int> sub_res;
            for (int i = 0; i < width; ++i) {
                TreeNode *node;
                node = q.front();
                sub_res.push_back(node->val);
                if (node->left != NULL)
                    q.push(node->left);
                if (node->right != NULL)
                    q.push(node->right);
                q.pop();
            }
            res.push_back(sub_res);
            sub_res.clear();
        }
        return res;
    }
};

int main(int argc, const char **argv) {
    Solution s;

    return 0;
}