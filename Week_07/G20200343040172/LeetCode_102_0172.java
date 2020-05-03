package week07.g20200343040172;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_102_0172 {

    /**
     * 使用队列来进行BFS遍历
     */
    class Solution1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            int level = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                ans.add(new ArrayList<Integer>());
                while (count > 0) {
                    count--;
                    TreeNode tmpNode = queue.poll();
                    ans.get(level).add(tmpNode.val);
                    if (tmpNode.left != null) {
                        queue.add(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        queue.add(tmpNode.right);
                    }
                }
                level++;
            }
            return ans;
        }
    }

    /**
     * 使用递归的方式来进行层次遍历，相当于是使用DFS的方式来进行层次遍历
     */
    class Solution2 {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();

        public void helper(TreeNode node, int level) {
            if (level == levels.size()) {
                levels.add(new ArrayList<>());
            }
            levels.get(level).add(node.val);
            if (node.left != null) {
                helper(node.left,level+1);
            }
            if (node.right != null) {
                helper(node.right,level+1);
            }
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return levels;
            }
            helper(root,0);
            return levels;
        }
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
