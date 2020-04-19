package com.alang.learn.week3;

import java.util.*;

/***
 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]



  

 示例 1:

 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 输出: 3
 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 示例 2:

 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 输出: 5
 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
  

 说明:

 所有节点的值都是唯一的。
 p、q 为不同节点且均存在于给定的二叉树中。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_236_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(8);
        treeNode.left.right.left = new TreeNode(7);
        treeNode.left.right.right = new TreeNode(4);
        System.out.println(solution.lowestCommonAncestor(treeNode, treeNode.left, treeNode.right).val);
        System.out.println(solution.lowestCommonAncestor(treeNode, treeNode.left, treeNode.left.right.right).val);

        System.out.println(solution.lowestCommonAncestor1(treeNode, treeNode.left, treeNode.right).val);
        System.out.println(solution.lowestCommonAncestor1(treeNode, treeNode.left, treeNode.left.right.right).val);
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) return root;
            TreeNode leftCommonAncestor = lowestCommonAncestor(root.left, p, q);
            TreeNode rightCommonAncestor = lowestCommonAncestor(root.right, p, q);
            if (leftCommonAncestor == null) {
                return rightCommonAncestor;
            }
            if (rightCommonAncestor == null) {
                return leftCommonAncestor;
            }
            return root;
        }

        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) return root;
            Stack<TreeNode> stack = new Stack<>();
            HashMap<TreeNode, TreeNode> parent = new HashMap<>();
            stack.push(root);
            parent.put(root, null);
            while (!parent.containsKey(p) || !parent.containsKey(q)) {
                TreeNode cur = stack.pop();
                if (cur.left != null) {
                    stack.push(cur.left);
                    parent.put(cur.left, cur);
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                    parent.put(cur.right, cur);
                }
            }
            HashSet<TreeNode> path = new HashSet<>();
            while (p != null) {
                path.add(p);
                p = parent.get(p);
            }
            while (q != null) {
                if (path.contains(q)) break;
                q = parent.get(q);
            }
            return q;
        }
    }
}
