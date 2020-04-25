package week03.g20200343040172;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * 本周作业
 * LeetCode-429 N ary tree level order traversal N叉树的层序遍历
 */
public class LeetCode_429_0172 {


    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 使用队列来实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_1(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }

    /**
     * 使用递归的方法进行遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_2(Node root) {
        if (root != null) {
            traverseNode(root, 0);
        }
        return result;
    }

    private void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1);
        }
    }

}
