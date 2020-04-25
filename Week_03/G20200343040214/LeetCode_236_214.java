package level2;

import tools.TreeNode;

public class Solution236 {
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursion(root, p, q);
        return ans;
    }

    private boolean recursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        int left = recursion(root.left, p, q) ? 1 : 0;
        int right = recursion(root.right, p, q) ? 1 : 0;
        int mid = ((root == p) || (root == q)) ? 1 : 0;
        if (mid + left + right >= 2) {
            this.ans = root;
        }
        // 找到p或q节点
        return (mid + left + right) > 0;
    }
}
