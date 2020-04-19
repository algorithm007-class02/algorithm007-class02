class LeetCode_98_0236{
    public double tmp = -Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValid(root);
    }

    public boolean isValid(TreeNode root) {
        if(root == null) return true;
        if(!isValid(root.left)) return false;
        if(root.val <= tmp ){
             return false;
            } else {
             tmp = root.val;
            }
        if(!isValid(root.right)) return false;
        return true;
    }
}