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
    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(Node root) {
        res = new ArrayList<>();
        if (root != null) {
            bfs(root, 0);
        }
        return res;
    }

    private void bfs(Node root, int level) {
        if (res.size() <= level) {
            res.add(new ArrayList<Integer>());
        }

        res.get(level).add(root.val);

        for (Node item : root.children) {
            bfs(item, level + 1);
        }
    }
}