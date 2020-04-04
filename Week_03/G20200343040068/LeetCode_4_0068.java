class LeetCode_4_0068 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root,result,0);
        return result;
    }

    private void dfs(Node node,List<List<Integer>> result,int level){
        if (result.size() <= level) result.add(new ArrayList<Integer>());

        result.get(level).add(node.val);
        for (Node n : node.children) {
            dfs(n,result,level+1);
        }


    }}