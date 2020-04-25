class LeetCode_1_0068 {

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    // 先子节点，后中节点
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }
    private void dfs(Node node,List<Integer> list){
        if (node == null) {
            return;
        }
        for (Node n : node.children) {
            dfs(n,list);
        }
        list.add(node.val);

    }
}