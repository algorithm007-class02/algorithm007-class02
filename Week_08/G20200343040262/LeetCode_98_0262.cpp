/*
 * @lc app=leetcode.cn id=98 lang=cpp
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// 中序遍历时，访问节点的值应为升序。若非升序则不是二叉搜索树
class Solution {
public:
    bool flag = true;
    long last = LONG_MIN;
    bool isValidBST(TreeNode *root) {
        if (!root)
            return true;
        if (flag && root->left)
            isValidBST(root->left);
        // 判断是否升序
        if (root->val <= last)
            flag = false;
        last = root->val;
        if (flag && root->right)
            isValidBST(root->right);
        return flag;
    }
};
// @lc code=end
