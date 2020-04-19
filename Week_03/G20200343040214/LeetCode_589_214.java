package level1;

import tools.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution589 {
    // N叉树的前序遍历
    public List<Integer> preorder(Node root) {
        List<Integer> re = new ArrayList<>();
        loop(re, root);
        return re;
    }

    public static void loop(List<Integer> list, Node node) {
        if (node != null) {
            // 从左到右
            list.add(node.val);
            for (Node n : node.children) {
                loop(list, n);
            }
        }
    }

    public List<Integer> postorder2(Node root) {
        // 不好理解
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null)
            return output;
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollFirst();
            output.add(node.val);
            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return output;
    }
}
