package com.yequan.leetcode.tree.ntreelevelorder_429;

import com.yequan.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * //给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * //
 * // 例如，给定一个 3叉树 :
 * //
 * //
 * //
 * //
 * //
 * //
 * //
 * // 返回其层序遍历:
 * //
 * // [
 * //     [1],
 * //     [3,2,4],
 * //     [5,6]
 * //]
 * //
 * //
 * //
 * //
 * // 说明:
 * //
 * //
 * // 树的深度不会超过 1000。
 * // 树的节点总数不会超过 5000。
 * // Related Topics 树 广度优先搜索
 *
 * @author : Administrator
 * @date : 2020/3/27
 */
public class NTreeLevelOrder {


    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(Node root, int level, List<List<Integer>> res) {
        if (null != root) {
            if (res.size() <= level) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.val);
            if (null != root.children) {
                for (Node child : root.children) {
                    helper(child, level + 1, res);
                }
            }
        }
    }

    /**
     * 广度优先: 队列法
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node nextNode = queue.poll();
                if (null != nextNode) {
                    level.add(nextNode.val);
                    if (null != nextNode.children) {
                        queue.addAll(nextNode.children);
                    }
                }
            }
            res.add(level);
        }
        return res;
    }

}
