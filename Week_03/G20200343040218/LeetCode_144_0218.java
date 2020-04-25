/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        doOrder(res, root);
        return res;
    }

    /**
     * dfs 递归实现
     */
    private void doOrder(List<Integer> res, TreeNode node) {
        if (null == node) {
            return;
        }
        res.add(node.val);
        if (null != node.left) {
            doOrder(res, node.left);
        }
        if (null != node.right) {
            doOrder(res, node.right);
        }
    }

    /**
     * 迭代实现
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            if (null == node) { continue; }
            res.add(node.val);
            deque.offerLast(node.right);
            deque.offerLast(node.left);
        }
        return res;
    }
}