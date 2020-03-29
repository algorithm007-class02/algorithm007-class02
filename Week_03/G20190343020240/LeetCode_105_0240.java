class Solution {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //1.前序遍历数组中的第一位是根节点
        //2.中序遍历中根节点左边的是左子树，右边的是右子树
        //3.递归左子树和右子树
        return helper(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if(pStart > pEnd || iStart > iEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        //找到root节点在inorder中的下标
        int index = 0;
        while(inorder[iStart + index] != preorder[pStart]){
            index++;
        }

        root.left = helper(preorder,pStart + 1,index,inorder,iStart,iStart + index - 1);
        root.right = helper(preorder,pStart + index + 1,pEnd,inorder,iStart + index + 1,iEnd);
        return root;
    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}