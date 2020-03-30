/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 //1.recursion, 采取中序遍历
 //其实这个递归是从树的最深处，一层层比较左右子树，逐层返回至根节点，一旦有哪个节点不满足则立即退出，效率还行！
class Solution {
public:
    bool flag = true;//baba VS son ?
    long last = LONG_MIN;//val of dad
    bool isValidBST(TreeNode* root) {
        if (!root) return true;//return when node is empty
        if (root -> left && flag) isValidBST(root -> left);
        if (root -> val <= last) flag = false;
        last = root -> val;
        if (root -> right && flag) isValidBST(root -> right);
        return flag;
    }
};