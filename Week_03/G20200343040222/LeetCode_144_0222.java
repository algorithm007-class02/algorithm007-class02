/**
 * 二叉树的前序遍历
 * 递归方法
 * 递归调用模版
 * 1终止条件
 * 2本层执行逻辑
 * 3递归调用自身
 * 4清除状态
 */
public class LeetCode_144_0222 {

    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }
}