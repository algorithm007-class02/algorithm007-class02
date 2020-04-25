/**
 * N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 先遍历子结点后遍历根结点
 * 用递归的思想去解决
 * 递归模版：
 * 1终止条件
 * 2本层代码执行的内容
 * 3递归调用
 * 4清除本层状态
 */
public class LeetCode_590_0222 {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<> ();
        traversal(root, result);
        return result;
    }

    private void traversal(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        for (Node singleChildren : node.children) {
            traversal(singleChildren, result);
        }
        result.add(node.val);
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