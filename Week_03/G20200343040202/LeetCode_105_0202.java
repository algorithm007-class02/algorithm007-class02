class Solution {
    
    int rootIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return  helperBuildTree(0,inorder.length,map,preorder);
    }

    private TreeNode helperBuildTree(int left, int right, Map<Integer, Integer> map, int[] preorder) {
        if (left >= right || rootIndex == preorder.length) {
            return null;
        }
        int value = preorder[rootIndex];
        TreeNode root = new TreeNode(value);

        rootIndex++;
        int index = map.get(value);
        root.left = helperBuildTree(left,index,map,preorder);
        root.right = helperBuildTree(index + 1,right,map,preorder);
        return root;
    }
}