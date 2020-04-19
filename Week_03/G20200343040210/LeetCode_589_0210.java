/** 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */

/**
 * 递归方法
 */
class Solution {
    List<Integer> res;
    public List<Integer> preorder(Node root) {
        res = new LinkedList<>();
        rec(root);
        return res;
    }
    public void rec(Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node children : root.children) {
            rec(children);
        }
    }
}

/** 递归
 * class Solution {
 *     public List<Integer> preorder(Node root) {
 *         List<Integer> res = new LinkedList<>();
 *         Stack<Node> stack = new Stack<>();
 *         if (root == null) return res;
 *         stack.push(root);
 *         while (!stack.empty()) {
 *             Node node = stack.pop();
 *             res.add(node.val);
 *             for (int i = node.children.size() - 1; i >= 0; --i) {
 *                 stack.push(node.children.get(i));
 *             }
 *         }
 *         return res;
 *     }
 * }
 */
