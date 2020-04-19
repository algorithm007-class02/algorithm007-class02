
//创建一个数组，先添加栈顶元素，把树的右元素先入栈，如果左元素为空则出栈添加进数组，左元素不为空则直接添加进数组
public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null) {
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            root = root.left;
            if (root == null && !stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return list;
}
