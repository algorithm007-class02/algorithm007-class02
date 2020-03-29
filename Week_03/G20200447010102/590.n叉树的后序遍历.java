import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
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
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack <Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            root =  stack.pop();
            result.add(root.val);
            for (Node node : root.children) {
                stack.add(node);
            }
        }
        Collections.reverse(result);
        return result;
    }

}
// @lc code=end

