class LeetCode_3_0068 {

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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> tmp = new LinkedList<>();
        tmp.add(root);
        while(!tmp.isEmpty()){
            TreeNode node = tmp.pollLast();
            result.add(node.val);
            if (node.right != null) {
                tmp.add(node.right);
            }
            if (node.left != null) {
                tmp.add(node.left);
            }
        }
        return result;
    }
}