
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


import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LeetCode_105_0206 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode res = new TreeNode(preorder[0]);
        //终止条件,中序节点为空
        if (preorder.length == 0) {
            return null;
        }

        //当前节点逻辑判断
        TreeNode root = new TreeNode(preorder[0]);
        int index = indexOf(inorder, preorder[0]);

        //drill down
        res.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),
                Arrays.copyOfRange(inorder, 0, index));
        res.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length),
                Arrays.copyOfRange(inorder, index+1, inorder.length));

        return root;
    }

    public int indexOf(int[] arr, int key){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
