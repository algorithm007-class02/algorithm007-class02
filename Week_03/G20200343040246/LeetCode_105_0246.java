package Week_03.G20200343040246;

class LeetCode_105_0246 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        
    }

    // 1. recursion
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || 
            inorder == null || inorder.length ==0 || preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // termination
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // process
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        while (inorder[inStart + index] != preorder[preStart]) {
            index++;
        }

        // recursion
        root.left = helper(preorder, preStart + 1, preStart + index, inorder, inStart, inStart + index - 1);
        root.right = helper(preorder, preStart + index + 1, preEnd, inorder, inStart + index + 1, inEnd);
        return root;
    }
}