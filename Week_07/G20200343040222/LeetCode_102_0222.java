/**
 * 二叉树的层次遍历
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode_102_0222 {

    /**
     * 非递归实现 用队列实现
     * @param root
     * 时间复杂度O(N) ,空间复杂度O(N) N为结点数量
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            res.add(new ArrayList<>());
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                res.get(currentLevel).add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            currentLevel++;
        }
        return res;

    }

    /**
     * 递归实现
     * @param root
     * 时间复杂度 O(N), 空间复杂度O(1) N为结点数量
     * @return
     */
    List<List<Integer>> resRe = new ArrayList<>();
    public List<List<Integer>> levelOrderRe(TreeNode root) {
        dfs(root, 0);
        return resRe;
    }

    private void dfs(TreeNode node , int level) {
        if (node == null) return;
        if (level == resRe.size()) {
            resRe.add(new ArrayList<>());
        }
        resRe.get(level).add(node.val);
        if (node.left != null) dfs(node.left, level + 1);
        if (node.right != null) dfs(node.right, level + 1);
    }

}
