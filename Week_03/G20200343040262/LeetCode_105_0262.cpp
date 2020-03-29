/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 /*
思路：依次使用前序数组中的元素分割中序数组，分割后递归处理。
preorder中的pos位置的元素preorder[pos]为根的子树必然对应着inorder数组中[left,right]之间的值。
一开始pos = 0，以preorder[0]为根的树，对应着inorder数组中[0, inorder.size()-1]之间的元素
preorder[0]在inorder中的位置为p，则将inorder数组分为[0, p-1]和[p+1, inorder.size()-1]两部分
这两部分分别对应左子树的节点集合和右子树的节点集合。
注意pos值要传入到子树中处理后再传出的，因为先序数组中，左子树的节点全部在右子树的前面。
 */
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int pos = 0;
        return buildTree(preorder, pos, inorder, 0, inorder.size() - 1);
    }

    TreeNode* buildTree(vector<int>& preorder, int& pos, vector<int>& inorder, int left, int right) {
        if (pos >= preorder.size()) return 0;
        int i = left;
        for (i = left; i <= right; i++) {
            if (inorder[i] == preorder[pos]) break;
        }
        TreeNode* root = new TreeNode(preorder[pos]);//root
        if (left <= i - 1) root -> left = buildTree(preorder, ++pos, inorder, left, i - 1);//左子树
        if (right >= i + 1) root -> right = buildTree(preorder, ++pos, inorder, i + 1, right);//右子树
        return root;
    }
};