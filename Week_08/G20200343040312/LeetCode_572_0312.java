//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
* 分解问题：
* 一、判断t是不是s的子树
*   1. t就是s本身
*       在这一步我们需要判断两棵树是不是相同的树 isSameTree（）：
*       递归到的两个树的节点都为null，true
*       递归到的两个树的节点一个为null，一个不为空，false
*       递归到的两个树的节点都不为空，则值相等时为true
*   2. t是s的左子树
*   3. t是s的右子树
*       判断t是否是s的子树时
**/

//leetcode submit region begin(Prohibit modification and deletion)

class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null && t==null) {return true;}  //当能递归到t树的空节点时，以一定为true
        if (s==null || t==null) {return false;}  //如果当前对比的两个节点，s为空，t不为空，则肯定不是子树
        if (s.val==t.val){
            return isSametree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
        } else {return isSubtree(s.left,t) || isSubtree(s.right,t);}
    }

    private boolean isSametree(TreeNode s, TreeNode t) {
        if (s==null && t==null) {return true;}
        if (s==null || t==null) {return false;}
        if (s.val==t.val){
            return isSametree(s.left, t.left) && isSametree(s.right, t.right);
        } else {return false;}
    }
}
//leetcode submit region end(Prohibit modification and deletion)
