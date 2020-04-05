package week_03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc_429_N_levelorder {
	public class Node {
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

	private void helper(Node n, int level, List<List<Integer>> result) {

		if (result.size() <= level) {
			result.add(new ArrayList<>());
		}

		List<Integer> r = result.get(level);
		r.add(n.val);

		if (n.children != null && !n.children.isEmpty()) {
			for (Node c : n.children) {
				if (c != null) {
					helper(c, level + 1, result);
				}
			}
		}
	}

	public List<List<Integer>> levelOrder_01(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		helper(root, 0, result);
		return result;
	}

	public List<List<Integer>> levelOrder_02(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<Node> q = new LinkedList<>();

		q.add(root);

		while (!q.isEmpty()) {

			int leve_size = q.size();

			List<Integer> r = new ArrayList<>(leve_size);

			for (int i = 0; i < leve_size; i++) {
				Node n = q.poll();
				r.add(n.val);

				if (n.children != null && !n.children.isEmpty()) {
					for (Node c : n.children) {
						if (c != null) {
							q.add(c);
						}
					}
				}
			}

			result.add(r);
		}

		return result;
	}
}
