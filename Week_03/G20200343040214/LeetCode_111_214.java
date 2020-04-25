package level1;

import tools.TreeNode;

public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // TODO 理解这一点 容易出错的地方
        // 有一边不存则只探查存在的一边
        if (left == 0 || right == 0)
            return left + right + 1;
        return left < right ? left + 1 : right + 1;
    }
}
