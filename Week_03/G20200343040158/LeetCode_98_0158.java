/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        long lastValue = Long.MIN_VALUE;
        
        while (!st.isEmpty() || root != null) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (root.val <= lastValue) return false;
            lastValue = (long)root.val;
            root = root.right;
        }
        return true;
    }
}