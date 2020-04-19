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
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);

        if (root.left != null) {
            preorderTraversal(root.left, res);
        }

        if (root.right != null) {
            preorderTraversal(root.right, res);
        }
    }
}