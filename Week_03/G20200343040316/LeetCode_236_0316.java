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

public class LeetCode_236_0316 {

    /**
     * 时间复杂度ON ,空间复杂度 ON
     *
     *
     * 思路，如果有一个节点等于 p或q，直接返回，
     * 递归分两步，第一步是left ,如果找到这点就返回带点，第二部同第一步，找到right点。 当层递归，root 是right和left的父节点
     * 如果，left和right都不为空，说明当前节点为最近公共祖先，如果有任一点为空时，表明其相反节点为最近祖先。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left != null && right != null) {
            return root;
        }

        return null;
    }


}
