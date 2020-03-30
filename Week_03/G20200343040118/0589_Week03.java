class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        dfs(root);
        return list;
    }
    public void dfs(Node root){
        if(root == null)
            return;
        list.add(root.val);
        for(int i = 0 ; i < root.children.size() ; i++){
            dfs(root.children.get(i));
        }
    }
}