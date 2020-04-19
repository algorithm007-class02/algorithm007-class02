//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
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
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            result.offerFirst(curr.val);
            for ( Node child : curr.children ) {
                stack.push(child);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * public List<Integer> postorder(Node root) {
 *         List<Integer> result = new ArrayList<>();
 *         dfs(root,result);
 *         return result;
 *     }
 *     void dfs(Node root,List<Integer> result) {
 *         if (root == null) return;
 *         for (Node node : root.children) {
 *             dfs(node,result);
 *         }
 *         result.add(root.val);
 *     }
 *
 */
