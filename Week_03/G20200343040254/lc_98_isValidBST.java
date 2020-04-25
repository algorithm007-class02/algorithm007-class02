package week_03;

import java.util.LinkedList;
import java.util.Stack;

public class lc_98_isValidBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private boolean helper(TreeNode n, Integer lower, Integer upper) {
		if (n == null)
			return true;

		int v = n.val;
		if (lower != null && v <= lower)
			return false;
		if (upper != null && v >= upper)
			return false;

		if (!helper(n.right, v, upper))
			return false;
		if (!helper(n.left, lower, v))
			return false;

		return true;
	}

	public boolean isValidBST_01(TreeNode root) {
		return helper(root, null, null);
	}

	private void update(LinkedList<TreeNode> stack, LinkedList<Integer> lowers, LinkedList<Integer> uppers, TreeNode n,
			Integer lower, Integer upper) {
		stack.add(n);
		lowers.add(lower);
		uppers.add(upper);
	}

	public boolean isValidBST_02(TreeNode root) {
		if (root == null)
			return true;

		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> lowers = new LinkedList<>();
		LinkedList<Integer> uppers = new LinkedList<>();

		Integer lower = null;
		Integer upper = null;

		update(stack, lowers, uppers, root, lower, upper);

		while (!stack.isEmpty()) {
			TreeNode n = stack.poll();

			lower = lowers.poll();
			upper = uppers.poll();

			if (n == null)
				continue;

			int v = n.val;

			if (lower != null && v <= lower)
				return false;
			if (upper != null && v >= upper)
				return false;

			update(stack, lowers, uppers, n.right, v, upper);
			update(stack, lowers, uppers, n.left, lower, v);
		}

		return true;
	}

	public boolean isValidBST_03(TreeNode root) {

		if (root == null)
			return true;

		double prev = -Double.MAX_VALUE;

		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = root;

		while (curr != null || !s.isEmpty()) {
			while (curr != null) {
				s.add(curr);
				curr = curr.left;
			}

			curr = s.pop();
			if (curr.val <= prev)
				return false;

			prev = curr.val;
			curr = curr.right;
		}

		return true;
	}
}
