import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
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
        Map<Integer,Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        TreeNode root = build(0, preorder.length-1, 0, inorder.length-1,preorder, inorder, inMap);
        return root;
    }

    private TreeNode build(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inMap){
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = build(preStart+1, preStart+numsLeft, inStart, inRoot-1, preorder, inorder, inMap);
        root.right = build(preStart+numsLeft+1, preEnd, inRoot+1, inEnd, preorder, inorder, inMap);
        return root;
    }
}

// @lc code=end

