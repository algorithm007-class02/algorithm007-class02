/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 1.递归
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<Integer>();
//         dfs_postorder(res, root);
//         return res;
//     }

//     void dfs_postorder(List<Integer> res, TreeNode root){
//         if(root == null) return;
//         dfs_postorder(res, root.left);
//         dfs_postorder(res, root.right);
//         res.add(root.val);
//     }
// }

// 2.迭代，注意跟前序遍历逆向
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode node = root;

        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                res.addFirst(node.val);
                node = node.right;
            }else {
                node = stack.pop();
                node = node.left;
            }
        }
        return res;
    }
}
// @lc code=end

