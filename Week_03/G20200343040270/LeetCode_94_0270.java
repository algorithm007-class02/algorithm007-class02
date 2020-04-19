/**
 * 给定一个二叉树，返回它的中序遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *      1
 *      \
 *      2
 *      /
 *      3
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
class Solution {

    /**
     * 解法一：递归
     * 时间复杂度：O(n)
     * 空间复杂度：平均O(logn)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode root,List<Integer> list){
        if(root == null) return;
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }


    /**
     * 解法二：栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    /**
     * 解法三：线索二叉树
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre;
        while (cur != null){
            if(cur.left == null){
                list.add(cur.val);
                cur = cur.right;
            }else {
                pre = cur.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = cur;
                TreeNode temp = cur.left;
                cur.left = null;
                cur = temp;
            }
        }
        return list;
    }
}