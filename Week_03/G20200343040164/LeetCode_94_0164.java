//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


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
    //莫里斯遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode pre = null;
        List<Integer> result = new ArrayList<>();
        while ( root != null ) {
            if ( root.left != null ) {
                pre = root.left;
                while ( pre.right != null ) {
                    pre = pre.right;
                }
                pre.right = root;
                TreeNode temp = root;
                root = root.left;
                temp.left = null;
            }else {
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**递归
 * public List<Integer> inorderTraversal(TreeNode root) {
 *         List<Integer> result = new ArrayList<>();
 *         helper(root,result);
 *         return result;
 *     }
 *     public void helper(TreeNode node, List<Integer> result){
 *         if ( node == null ) return;
 *         helper(node.left,result);
 *         result.add(node.val);
 *         helper(node.right,result);
 *     }
 *
 */
/**栈
 * public List<Integer> inorderTraversal(TreeNode root) {
 *         List<Integer> result = new ArrayList<>();
 *         Stack<TreeNode> stack = new Stack<>();
 *         while ( stack.size() > 0 || root != null ) {
 *             if ( root != null ) {
 *                 stack.add(root);
 *                 root = root.left;
 *             }else {
 *                 TreeNode temp = stack.pop();
 *                 result.add(temp.val);
 *                 root = temp.right;
 *             }
 *         }
 *         return result;
 *     }
 */
