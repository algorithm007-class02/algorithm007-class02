class Solution {
     List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
         dfs(root);
        return list;
    }
     public void dfs(Node root){
        if(root == null)
            return;
        for(int i = 0 ; i < root.children.size() ; i++){
            dfs(root.children.get(i));
        }
         list.add(root.val);
    }
}