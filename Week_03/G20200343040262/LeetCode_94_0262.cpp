/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

 //思路2：迭代法，左根右，深度优先遍历，DFS
 //与前序稍有不同，向左遍历根节点的所有左子树后，输出无左孩子的子树根节点，再换该根节点的右子树的所有左孩子遍历，输出即可
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root) {
            stack<TreeNode*> S;
            TreeNode* node = root;
            while (node || !S.empty()) {
                while (node) {
                    S.push(node);
                    node = node -> left;
                }
                node = S.top();
                res.push_back(node -> val);
                S.pop();
                node = node -> right;
            }
        }
        return res;
    }
};