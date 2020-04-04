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


    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        doOrder(res, root);
        return res;
    }

    /**
     * dfs 递归
     */
    private void doOrder(List<Integer> res, Node node) {
        if (null == node) { return; }
        res.add(node.val);
        for (Node child : node.children) {
            doOrder(res, child);
        }
    }

    /**
     * 迭代实现
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();

        Deque<Node> deque = new LinkedList<>();
        deque.add(root);

        while(!deque.isEmpty()) {
            Node node = deque.pollLast();
            if (null == node) { continue; }
            res.add(node.val);
            List<Node> children = node.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                deque.offerLast(children.get(i));
            }
        }
        return res;
    }
}