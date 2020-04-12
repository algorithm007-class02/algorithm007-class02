给定一个二叉树，返回它的 前序 遍历。 

 示例 

 输入 [1,null,2,3]  
   1
    
     2
    
   3 

输出 [1,2,3]
 

 进阶 递归算法很简单，你可以通过迭代算法完成吗？ 
 Related Topics 栈 树


leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;


  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class Solution144 {
    public ListInteger preorderTraversal(TreeNode root) {

        ListInteger list = new ArrayList();
        helper(root,list);
        return list;
    }

    private void helper(TreeNode root, ListInteger list) {
        if (root!=null){
            list.add(root.val);
            if (root.left!=null){
                helper(root.left,list);
            }
            if (root.right!=null){
                helper(root.right, list);
            }
        }
    }
}
leetcode submit region end(Prohibit modification and deletion)
