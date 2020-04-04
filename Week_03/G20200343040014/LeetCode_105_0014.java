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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) return null;
        TreeNode tree = buildNewTree(preorder, 0, preorder.length -1, inorder, 0, inorder.length - 1);
        return tree;
    }

        public TreeNode buildNewTree (int[] p, int pLeft, int pRight, int[]i,int iLeft, int iRight){
        if (pLeft > pRight || iLeft > iRight) {
            return null;
        }
        TreeNode tree = new TreeNode(p[pLeft]);
        int index = 0;
        while (i[iLeft + index] != p[pLeft]) {
            index++;
        }

        tree.left = buildNewTree(p, pLeft + 1, pLeft + index, i, iLeft, iLeft + index -1);
        tree.right = buildNewTree(p, pLeft + 1+ index, pRight,i, iLeft + index +1, iRight);
        return tree;
    }
}