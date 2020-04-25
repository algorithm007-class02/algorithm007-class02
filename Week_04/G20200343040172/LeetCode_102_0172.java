package week04.g20200343040172;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * LeetCode-102 Binary tree level order traversal 二叉树的层序遍历
 */
public class LeetCode_102_0172 {

    class Solution {
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
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
