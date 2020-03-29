import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 

class Solution {
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     if (root == null) {
    //         return ans;
    //     }
    //     recursionTraversal(root, ans);
    //     return ans;
    // }

    // private void recursionTraversal(TreeNode node, List<Integer> ans) {
    //     if (node == null) {
    //         return;
    //     }
    //     ans.add(node.val);
    //     if (node.left != null) {
    //         recursionTraversal(node.left, ans);
    //     }
    //     if (node.right != null) {
    //         recursionTraversal(node.right, ans);
    //     }
    // }

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.remove();
            output.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return output;
    }
}