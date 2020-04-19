package week_03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class lc_590_N_postorder {

	public static class Node {

		public int val;

		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	private void helper(Node n, List<Integer> result) {
		if (n.children != null && !n.children.isEmpty()) {
			for (Node c : n.children) {
				if (c != null) {
					helper(c, result);
				}
			}
		}

		result.add(n.val);
	}

	public List<Integer> postorder_01(Node root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		helper(root, result);
		return result;
	}

	public List<Integer> postorder(Node root) {
		LinkedList<Integer> result = new LinkedList<Integer>();

		if (root == null)
			return result;

		Stack<Node> s = new Stack<>();
		s.push(root);

		while (!s.isEmpty()) {
			Node n = s.pop();

			result.addFirst(n.val);

			if (n.children != null && !n.children.isEmpty()) {
				for (Node c:n.children) {
					if (c != null) {
						s.push(c);
					}
				}
			}
		}

		return result;
	}
}
