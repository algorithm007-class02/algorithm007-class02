/**
 * 给定一个二叉树，返回它的前序遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *      1
 *      \
 *      2
 *      /
 *      3
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
class Solution {

    /**
     * 解法一：递归
     * 时间复杂度：O(n)
     * 空间复杂度：平均O(logn),最坏O(n) 链表
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }


    /**
     * 解法二：
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
}