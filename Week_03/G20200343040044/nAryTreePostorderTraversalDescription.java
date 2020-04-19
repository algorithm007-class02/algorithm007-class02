package postorderTraversalDescription;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author VITI.lewis
 * @Despriction:
 * @Date:Created in 2020/3/29 9:58 下午
 * @Modify By:
 */
public class nAryTreePostorderTraversalDescription {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--) {
                stack.add(root.children.get(i));
            }
        }

        return list;
    }
}
