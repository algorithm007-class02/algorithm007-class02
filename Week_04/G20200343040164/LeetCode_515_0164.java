//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    public List<Integer> largestValues(TreeNode root) {
          List<Integer> result = new ArrayList<>();
          if (root == null) return result;

          LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
          queue.add(root);
          while (!queue.isEmpty()) {
              TreeNode temp;
              int maxValue = Integer.MIN_VALUE;
              int len = queue.size();
              for (int i = 0; i < len; i++) {
                  temp = queue.remove();
                  maxValue = temp.val > maxValue ? temp.val : maxValue;
                  if (temp.left != null) queue.add(temp.left);
                  if (temp.right != null) queue.add(temp.right);
              }
              result.add(maxValue);
          }

        return result;
     }
}
//leetcode submit region end(Prohibit modification and deletion)
