package level2;

import tools.TreeNode;

import java.util.*;

public class Solution515 {
    public static void main(String[] args) {
    }

    // 广度
    public static List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelCount = 1;
        int max = Integer.MIN_VALUE;
        // 每一层的遍历结束不能以队列为空作为判断条件 哦
        while (!queue.isEmpty()) {
            while (levelCount > 0) {
                // 每一层的元素都要取出
                TreeNode node = queue.remove();
                max = Math.max(node.val, max);
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
                levelCount -= 1;
            }
            res.add(max);
            // 重置
            max = Integer.MIN_VALUE;
            levelCount = queue.size();
        }
        return res;
    }

    // 深度
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(root.val);
        dfs(root, 1, res);
        return res;
    }

    private static void dfs(TreeNode node, int level, List<Integer> res) {
        if (node != null) {
            int val = node.val;
            if (res.size() >= level) {
                if (res.get(level - 1) <= val) {
                    res.set(level - 1, val);
                }
            } else {
                res.add(node.val);
            }
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null || right != null) {
                if (left != null) {
                    dfs(left, level + 1, res);
                }
                if (right != null) {
                    dfs(right, level + 1, res);
                }
            }
        }
    }

}
