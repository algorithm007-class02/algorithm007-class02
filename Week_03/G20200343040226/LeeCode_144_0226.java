package com.logic;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: welllu
 * @Date: 2020/3/28 17:26
 * @Description:
 */
public class LeeCode_144_0226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List <Integer> preorderTraversal(TreeNode root) {

        LinkedList <Integer> list = new LinkedList <> ();

        LinkedList <TreeNode> stack = new LinkedList <> ();

        if (root != null) {
            stack.add ( root );
        }

        while (!stack.isEmpty ()) {
            TreeNode node = stack.pollLast ();
            list.add ( node.val );
            if (node.right != null) stack.add ( node.right );
            if (node.left != null) stack.add ( node.left );
        }

        return list;
    }
}
