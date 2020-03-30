package com.logic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/**
 * @Auther: welllu
 * @Date: 2020/3/28 18:46
 * @Description:
 */
public class LeeCode_236_0226 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //父指针迭代

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map <TreeNode, TreeNode> parent = new HashMap <> ();
        Stack <TreeNode> stack = new Stack <> ();

        parent.put ( root, null );
        stack.add ( root );

        while (!parent.containsKey ( p ) || !parent.containsKey ( q )) {

            TreeNode node = stack.pop ();

            if (node.left != null) {
                parent.put ( node.left, node );
                stack.add ( node.left );
            }
            if (node.right != null) {
                parent.put ( node.right, node );
                stack.add ( node.right );
            }
        }

        HashSet <TreeNode> parentSet = new HashSet <> ();

        while (p != null) {
            parentSet.add ( p );
            p = parent.get ( p );
        }

        while (!parentSet.contains ( q )) {
            q = parent.get ( q );
        }

        return q;
    }
}
