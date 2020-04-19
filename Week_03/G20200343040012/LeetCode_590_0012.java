class Solution {
    /**
     * 递归后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> arr = new ArrayList<>();
        dfs(arr, root);
        return arr;
    }

    void dfs(List<Integer> list, Node node) {
        if (node == null) {
            return;
        }
        for (Node child : node.children) {
            dfs(list, child);
        }
        list.add(node.val);
    }

    /**
     * 迭代实现
     *
     * @param root
     * @return
     */
    public List<Integer> postorder_1(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for (Node node : root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }
}