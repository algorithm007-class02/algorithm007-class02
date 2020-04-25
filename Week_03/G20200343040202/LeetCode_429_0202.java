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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null){
            helperLevelOrder(root, lists,0);
        }
        return lists;
    }

    private void helperLevelOrder(Node root, List<List<Integer>> lists,int level) {
        if (lists.size() == level){
            lists.add(new ArrayList<Integer>());
        }
        lists.get(level).add(root.val);
        for (Node node : root.children) {
            helperLevelOrder(node,lists,level + 1);
        }
    }

    // public List<List<Integer>> levelOrder(Node root) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     if (root == null) return result;
    //     Queue<Node> queue = new LinkedList<>();
    //     queue.add(root);
    //     while (!queue.isEmpty()) {
    //         List<Integer> level = new ArrayList<>();
    //         int size = queue.size();
    //         for (int i = 0; i < size; i++) {
    //             Node node = queue.poll();
    //             level.add(node.val);
    //             queue.addAll(node.children);
    //         }
    //         result.add(level);
    //     }
    //     return result;
    // }
}