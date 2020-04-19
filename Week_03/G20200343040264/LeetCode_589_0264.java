
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

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        preorder(root, resultList);
        return resultList;
    }

    private void preorder(Node root, List<Integer> resultList){
        if (root == null) {
            return;
        }
        resultList.add(root.val);
        List<Node> children = root.children;
        for (int i = 0; i < children.size(); i++) {
            preorder(children.get(i),resultList);
        }
    }
}