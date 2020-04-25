package week_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc_589_N_preorder {

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
	
	
	
	private void helper(Node n,List<Integer> result) {
		
		if (n.children != null && !n.children.isEmpty()) {
			for (Node c : n.children) {
				if (c != null) {
					helper(c, result);
				}
			}
		}
		
		result.add(n.val);
	}

	public List<Integer> preorder_01(Node root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		
		helper(root, result);
		
		return result;
	}
	
	public List<Integer> preorder_02(Node root) {
		
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		
		Stack<Node> s = new Stack<>();
		s.push(root);

		while (!s.isEmpty()) {
			Node n = s.pop();

			result.add(n.val);

			if (n.children != null && !n.children.isEmpty()) {
				for (int i = n.children.size() - 1; i >= 0; i--) {
					Node c = n.children.get(i);
					if (c != null) {
						s.push(c);
					}
				}
			}
		}

		return result;
	}
}
