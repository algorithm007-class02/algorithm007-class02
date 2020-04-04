/**144. 二叉树的前序遍历
 *
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        order(root, res);
        return res;
    }
    void order(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        order(root.left, res);
        order(root.right, res);
    }
}

/**
 * class Solution {
 *     public List<Integer> preorderTraversal(TreeNode root) {
 *         List<Integer> res = new ArrayList<>();
 *         Stack<TreeNode> st = new Stack<TreeNode>();
 *         while (root != null || !st.empty()) {
 *             while (root != null) {
 *                 res.add(root.val);
 *                 st.push(root);
 *                 root = root.left;
 *             }
 *             root = st.pop();
 *             root = root.right;
 *         }
 *         return res;
 *     }
 * }
 */
