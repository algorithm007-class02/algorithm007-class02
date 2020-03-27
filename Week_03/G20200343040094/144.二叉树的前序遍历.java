/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<Integer>();
//         DFS_Preorder(root, res);
//         return res;
//     }

//     void DFS_Preorder(TreeNode root, List<Integer> res){
//         if(root == null) return;
//         res.add(root.val);
//         DFS_Preorder(root.left, res);
//         DFS_Preorder(root.right, res);
//     }
// }

// 2.迭代-栈模拟递归
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            if(node != null){
                res.add(node.val);
                stack.push(node.right);
                node = node.left;
            }else {
                node = stack.pop();
            }
        }
        return res;
    }
}




// @lc code=end

