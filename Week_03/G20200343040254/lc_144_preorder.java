package week_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc_144_preorder {
	public static class TreeNode
	{
		int val;
		
		TreeNode left;
		
		TreeNode right;
	}
	
	
	private void preOrder(TreeNode n,List<Integer> result) {
		if (n != null) {
			result.add(n.val);
			
			if (n.left != null) preOrder(n.left, result);
			if (n.right != null) preOrder(n.right, result);
		}
	}
	
	
	 public List<Integer> preorderTraversal_01(TreeNode root) {
		  	List<Integer> result = new ArrayList<Integer>();
		  	if (root == null) return result;
		  	
		  	preOrder(root, result);
		  	return  result;
	 }
	 
	 
	 public List<Integer> preorderTraversal(TreeNode root) {
		 
		  	List<Integer> result = new ArrayList<Integer>();
		  	if (root == null) return result;
		  	Stack<TreeNode> s = new Stack<>();
		  	s.push(root);

		  	while(!s.isEmpty()) {
		  		TreeNode n = s.pop();
		  		result.add(n.val);
		  		
		  		if (n.right != null) s.push(n.right);
		  		if (n.left != null) s.push(n.left);
		  	}
		  	
		  	return result;
	 }
}
