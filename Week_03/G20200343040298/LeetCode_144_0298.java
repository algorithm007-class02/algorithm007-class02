/**
 * 递归
 * 根节点 ——＞左子树　——＞　右子树
 * 左为null,访问右
 * 右为null,返回上一层
 */


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            helper(node.left, res);
            helper(node.right, res);
        }
    }
}
