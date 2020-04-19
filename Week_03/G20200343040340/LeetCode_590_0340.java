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
}
class Solution {
  List<Integer> list = new ArrayList<>();
  List<Node> stack = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return list;
        stack.add(root);
        while(stack.size() > 0) {
            Node node = stack.remove(stack.size() - 1);
            list.add(node.val);
            for(Node child : node.children){
                stack.add(child);
            }
        }
        Collections.reverse(list);
        return list;
    }
}