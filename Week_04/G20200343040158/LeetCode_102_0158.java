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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        DFS(root, 0, res);
        return res;
    }

    private void DFS(TreeNode root, int depth, List<List<Integer>> res) {
        if (root != null) {
            if (depth+1 > res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(depth).add(root.val);
            if (root.left != null) {
                DFS(root.left, depth+1, res);
            }
            if (root.right != null) {
                DFS(root.right, depth+1, res);
            }
        }
    }
}