class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
             dfs(root);
            return list;
    }
     public void dfs(TreeNode root) {
        if(root == null){
            return ;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}