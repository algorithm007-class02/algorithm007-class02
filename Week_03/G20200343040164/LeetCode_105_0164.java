//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


//leetcode submit region begin(Prohibit modification and deletion)
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if ( preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length )
            return null;
        return help(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode help(int[] pre, int preStart, int preEnd, int[] In, int InStart, int InEnd) {
        if (preStart > preEnd || InStart > InEnd) return null;
        //create root
        TreeNode root = new  TreeNode(pre[preStart]);
        int index = 0;
        while ( In[InStart + index] != pre[preStart] )  index++;
        root.left = help(pre,preStart+1,preStart+index,In,InStart,InStart+index-1);
        root.right = help(pre,preStart+index+1,preEnd,In,InStart+index+1,InEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
