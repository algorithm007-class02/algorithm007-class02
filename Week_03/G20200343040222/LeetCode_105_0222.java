/**
 * 从前序与中序遍历序列构造二叉树
 */
public class LeetCode_105_0222 {
    /**
     * 前序遍历为根左右。 中序遍历为左根右。
     * 所以前序遍历的第一个元素为重建的二叉树的根节点的值。
     * 遍历中序遍历，直到找到和根节点值相同的位置。则此元素左边的都是根节点的左子树的元素，右边的都是根节点右子树的元素。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return traversalNode(preorder, 0 , preorder.length - 1, inorder, 0, preorder.length - 1);
    }

    private TreeNode traversalNode(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        int index = 0;
        while (inorder[inStart + index] != preorder[preStart]) {
            index++;
        }
        treeNode.left = traversalNode(preorder, preStart + 1, preStart + index, inorder, inStart, inStart + index - 1);
        treeNode.right = traversalNode(preorder, preStart + index + 1, preEnd, inorder, inStart + index + 1, inEnd);
        return treeNode;
    }


}