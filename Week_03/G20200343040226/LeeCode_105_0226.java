package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/3/28 19:06
 * @Description:
 */
public class LeeCode_105_0226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return travel ( preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1 );
    }

    private TreeNode travel(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        //terminator
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        TreeNode root = new TreeNode ( preorder[pStart] );
        //process data -> find inorder root
        int index = 0;
        while (inorder[iStart + index] != preorder[pStart]) {
            index++;
        }
        //sub problems
        root.left = travel ( preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1 );
        root.right = travel ( preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1, iEnd );

        //restore the current state
        return root;
    }

}
