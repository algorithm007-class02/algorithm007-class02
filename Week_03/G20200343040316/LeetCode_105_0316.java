package com.wxs.algorithm1.week03;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-29
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_105_0316 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || preorder.length < 1 || inorder == null || inorder.length < 1 || preorder.length != inorder.length)
            return null;

        return helper(preorder,0,preorder.length - 1, inorder,0,inorder.length -1);

    }

    private TreeNode helper(int[] preorder, int pstart, int pEnd, int[] inorder, int iStart, int iEnd) {
        // 递归终止条件
        if(pstart > pEnd || iStart > iEnd){
            return null;
        }
        // 构建根节点
        TreeNode root = new TreeNode(preorder[pstart]);

        // 找出根节点在 中序遍历的位置
        int x = 0;

        while (inorder[iStart+x] != root.val){
            x++;
        }

        root.left = helper(preorder,pstart+1,pstart+x,inorder,iStart,iStart+x-1);
        root.right = helper(preorder,pstart+x + 1,pEnd,inorder,iStart+x+1,iEnd);


        return root;
    }


}
