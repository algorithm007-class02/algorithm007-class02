class Solution {

    /**
     * 递归前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        dfs(arr, root);
        return arr;
    }

    void dfs(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        dfs(list, node.left);
        dfs(list, node.right);
    }

    /**
     * 迭代实现
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node != null){
                list.add(node.val);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }
        return list;
    }
}