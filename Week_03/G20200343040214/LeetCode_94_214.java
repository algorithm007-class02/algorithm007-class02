package level2;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。若二叉树为空则结束返回
public class Solution94 {
    // 标记遍历
    static class Tag {
        public TreeNode node;
        public int tag;

        public Tag(int tag, TreeNode node) {
            this.tag = tag;
            this.node = node;
        }
    }

    // 采用栈
    public static int WHITE = 0;
    public static int GRAY = 1;

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<Tag> nodeStack = new Stack<>();
        nodeStack.push(new Tag(WHITE, root));
        while (!nodeStack.isEmpty()) {
            Tag top = nodeStack.pop();
            if (top.node == null)
                continue;
            if (top.tag == WHITE) {
                nodeStack.push(new Tag(WHITE, top.node.right));
                nodeStack.push(new Tag(GRAY, top.node));
                nodeStack.push(new Tag(WHITE, top.node.left));
            } else {
                list.add(top.node.val);
            }
        }
        return list;
    }

    // 采用栈
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode point = root;
        nodeStack.push(point);
        while (point != null || !nodeStack.isEmpty()) {
            while (point != null) {
                nodeStack.push(point);
                point = point.left;
            }
            // 到达叶子节点 也就是 point == null
            // 取出栈顶元素
            point = nodeStack.pop();
            list.add(point.val);
            // 遍历父节点的右子树 如果没有右子树则继续弹出栈顶元素 -- 取父节点
            point = point.right;
        }
        return list;
    }

    // 递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        loop(root, list);
        return list;
    }

    public static void loop(TreeNode node, List<Integer> list) {
        if (node != null) {
            TreeNode left = node.left;
            // 先遍历左子树
            loop(left, list);
            // 根节点
            list.add(left.val);
            TreeNode right = node.right;
            // 再遍历右子树
            loop(right, list);
        }
    }
}
