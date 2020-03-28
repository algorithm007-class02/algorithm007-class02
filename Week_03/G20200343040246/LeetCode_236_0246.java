package Week_03.G20200343040246;

import java.util.*;

class LeetCode_236_0246 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        
    }

    // 1. recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    // 2. iterative
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        stack.push(root);
        parent.put(root, null);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode cur = stack.pop();
            if (cur.left != null) {
                stack.push(cur.left);
                parent.put(cur.left, cur);
            }
            if (cur.right != null) {
                stack.push(cur.right);
                parent.put(cur.right, cur);
            }
        }

        HashSet<TreeNode> path = new HashSet<>();
        while (p != null) {
            path.add(p);
            p = parent.get(p);
        }
        while (q != null) {
            if (path.contains(q)) {
                break;
            }
            q = parent.get(q);
        }
        return q;
    }

}