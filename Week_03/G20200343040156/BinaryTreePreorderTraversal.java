class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> re = new ArrayList<>();
        helper(re,root);
        return re;
    }
    public List<Integer> helper(List<Integer> re ,TreeNode root){

        if(null!=root){
            re.add(root.val);
            if(null!=root.left){
                helper(re,root.left);
            }
            if(null!=root.right){
                helper(re,root.right);
            }
        }
        return re;
    }
}