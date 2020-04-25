package level1;

import tools.TreeNode;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        return Math.max(maxDepth(left), maxDepth(right)) + 1;
    }
}
