/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //前序遍历preorder，中序遍历：inorder，找到preorder中值等于inorder根节点的index,
    // 将前序遍历划分为{根节点，左子树，右子树},将中序遍历划分为{左子树，根节点，右子树}。
    //递归，直到无子节点返回null终止。
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
        return help(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }


    private TreeNode help(int[] preorder,int pStart,int pEnd, int[] inorder,int iStart,int iEnd) {
        if (pEnd > preorder.length - 1 || iEnd > inorder.length - 1 || pStart > pEnd || iStart > iEnd) return null;
        TreeNode node = new TreeNode(preorder[pStart]);
        int index = 0;
        while(inorder[iStart + index] != node.val) index++;
        node.left = help(preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1);
        node.right = help(preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1 , iEnd);
        return node;
    }
}