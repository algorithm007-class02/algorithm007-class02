/** 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历
 */
class Solution {
    List<Integer> res;
    public List<Integer> postorder(Node root) {
        res = new LinkedList<>();
        rec(root);
        return res;
    }
    public void rec(Node root) {
        if (root == null) {
            return;
        }
        for (Node children : root.children) {
            rec(children);
        }
        res.add(root.val);
    }
}

/**
 *class Solution {
 *      public List<Integer> postorder(Node root) {
 *         LinkedList<Integer> res = new LinkedList<>();
 *         Stack<Node> stack = new Stack<>();
 *         if (root == null) return res;
 *         stack.push(root);
 *         while (!stack.empty()) {
 *             Node node = stack.pop();
 *             res.offerFirst(node.val);
 *             for (Node children : node.children) {
 *                 stack.push(children);
 *             }
 *         }
 *         return res;
 *     }
 * }
 */
