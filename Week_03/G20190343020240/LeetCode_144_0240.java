import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}

/**
 * 前序遍历->非递归->根左右
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(null == root) return list;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);

            if (temp.right != null)
                stack.push(temp.right);

            if (temp.left != null)
                stack.push(temp.left);
        }

        return list;
    }
}