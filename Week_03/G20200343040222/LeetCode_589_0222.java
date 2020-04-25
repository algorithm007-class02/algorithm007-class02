/**
 * N叉树的前序遍历
 * 先父结点后子结点
 * 递归模版：
 * 1终止条件
 * 2本层执行逻辑
 * 3执行递归调用
 * 4清除本层状态
 *
 *
 */
public class LeetCode_589_0222 {
    List<Integer> result = new ArrayList();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        for (Node singleChildren : root.children) {
            preorder(singleChildren);
        }
        return result;
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
    };

}