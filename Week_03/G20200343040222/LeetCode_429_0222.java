/**
 * N叉树的层序遍历
 * 层次遍历的关键是在递归的时候注意观测当前递归数层次 和数的层次是一样的， 所以递归方法要传入层数
 *
 *
 */
public class LeetCode_429_0222 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return result;
        }
        levelOrderTraversal(root, 0);
        return result;
    }

    private void levelOrderTraversal(Node node, int level) {
        if (node == null) return;
        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node singleNode : node.children) {
            if (singleNode != null) {
                levelOrderTraversal(singleNode, level + 1);
            }
        }
    }

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
}