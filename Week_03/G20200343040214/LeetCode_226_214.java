package level1;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution226 {
    public static void main(String[] args) {

    }

    // 深度优先搜所 -- 递归
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    public static TreeNode dfs(TreeNode node) {
        if (node == null)
            return null;
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = dfs(right);
        node.right = dfs(left);
        return node;
    }

    // 广度优先搜索 -- 迭代
    /**
     * 通过队列来保存每一个层级的元素 交换完一个层级再继续下一个层级 整个过程中要注意子节点的判空-- 叶子节点
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            TreeNode temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;
            if (currentNode.left != null) {
                queue.add(currentNode.right);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.left);
            }
        }
        return root;
    }
}
