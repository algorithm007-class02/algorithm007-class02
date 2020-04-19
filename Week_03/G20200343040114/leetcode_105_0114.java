import java.util.HashMap;

/*
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

class Solution {
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            idx_map.put(inorder[i], i);
        }
        return helper(0, preorder.length);
    }

    // 区间为左闭右开[left_index, right_index)
    private TreeNode helper(int left_index, int right_index) {
        System.out.println("pre_idx: " + pre_idx + "  left_index: " + left_index + "  right_index:" + right_index);
        if (left_index == right_index) {
            return null;
        }
        int rootValue = preorder[pre_idx];
        TreeNode root = new TreeNode(rootValue);
        int inIndex = idx_map.get(rootValue);
        pre_idx++;
        root.left = helper(left_index, inIndex);
        root.right = helper(inIndex + 1, right_index);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
