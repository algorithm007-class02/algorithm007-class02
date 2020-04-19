package com.yequan.leetcode.tree.preordertraversal_144;

import com.yequan.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * //给定一个二叉树，返回它的 前序 遍历。
 * //
 * // 示例:
 * //
 * // 输入: [1,null,2,3]
 * //   1
 * //    \
 * //     2
 * //    /
 * //   3
 * //
 * //输出: [1,2,3]
 * //
 * //
 * // 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * // Related Topics 栈 树
 *
 * @author : Administrator
 * @date : 2020/3/25
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (null != root) {
            res.add(root.val);
            if (null != root.left) {
                helper(root.left, res);
            }
            if (null != root.right) {
                helper(root.right, res);
            }
        }
    }

}
