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
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null){
            return list;
        }
        if (root.children.size() == 0){
            list.add(root.val);
            return list;
        }
        for (int i = 0; i < root.children.size(); i++){
            Node node = root.children.get(i);
            List subList = postorder(node);
            list.addAll(subList);
        }
        list.add(root.val);
        return list;
    }
}