package week_03;

import java.util.HashMap;
import java.util.Map;

public class lc_105_buildTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0)
			return null;
		if (inorder == null || inorder.length == 0)
			return null;
		if (preorder.length != inorder.length)
			return null;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helper(map, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode helper(Map<Integer, Integer> map, int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
		if (ps > pe || is > ie)
			return null;

		TreeNode root = new TreeNode(preorder[ps]);
		int index = map.get(root.val) - is;
		root.left = helper(map, preorder, ps + 1, ps + index, inorder, is, is + index - 1);
		root.right = helper(map, preorder, ps + index + 1, pe, inorder, is + index + 1, ie);
		return root;
	}
}
