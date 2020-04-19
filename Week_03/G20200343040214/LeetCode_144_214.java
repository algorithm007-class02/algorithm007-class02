package level2;

//1.前序遍历：先访问根节点——左子树——右子树。
//2.中序遍历：先访问左子树——根节点——右子树，按照这个顺序。
//3.后序遍历：和前面差不多，先访问树的左子树——右子树——根节点。按层遍历：把一棵树从上到下，从左到右依次写出来
import tools.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 二叉树的前序遍历
// 先访问根节点——左子树——右子树。
public class Solution144 {
    // 标记遍历
    static class Tag {
        public TreeNode node;
        public int tag;

        public Tag(int tag, TreeNode node) {
            this.tag = tag;
            this.node = node;
        }
    }

    // 采用栈+标记
    public static int WHITE = 0;
    public static int GRAY = 1;

    public List<Integer> preorderTraversal(TreeNode root) {
        // TODO 1
        List<Integer> list = new ArrayList<>();
        Stack<Tag> nodeStack = new Stack<>();
        nodeStack.push(new Tag(WHITE, root));
        while (!nodeStack.isEmpty()) {
            Tag top = nodeStack.pop();
            if (top.node == null)
                continue;
            if (top.tag == WHITE) {
                nodeStack.push(new Tag(WHITE, top.node.right));
                nodeStack.push(new Tag(WHITE, top.node.left));
                nodeStack.push(new Tag(GRAY, top.node));
                // 先 右 左 根入栈 -- 》 出栈顺序 根 左 右
            } else {
                list.add(top.node.val);
            }
        }
        return list;
    }

    // 采用栈
    public List<Integer> preorderTraversal2(TreeNode root) {
        // TODO 2
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode point = root;
        while (point != null || !nodeStack.isEmpty()) {
            while (point != null) {
                nodeStack.push(point);
                list.add(point.val);
                point = point.left;
            }
            // 到达叶子节点 也就是 point == null
            // 取出栈顶元素
            point = nodeStack.pop();
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
            // 根节点
            list.add(left.val);
            // 先遍历左子树
            loop(left, list);
            TreeNode right = node.right;
            // 再遍历右子树
            loop(right, list);
        }
    }
}
