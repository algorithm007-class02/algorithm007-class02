//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        if (root == null ) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> result = new ArrayList<>();
        while ( !stack.isEmpty() ) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if ( node.right != null ) {
                stack.push(node.right);
            }
            if ( node.left != null ) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**递归
 * public List<Integer> preorderTraversal(TreeNode root) {
 *         List<Integer> result = new ArrayList<>();
 *         helper(root,result);
 *         return result;
 *     }
 *     public void helper(TreeNode node , List<Integer> result){
 *         if (node == null) return;
 *         result.add(node.val);
 *         helper(node.left,result);
 *         helper(node.right,result);
 *     }
 */
