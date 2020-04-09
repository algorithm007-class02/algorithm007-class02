package week_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc_94_inorder {

	
	public static class TreeNode
	{
		int value;
		
		TreeNode left;
		
		TreeNode right;
	}
	
	 public List<Integer> inorderTraversal_01(TreeNode root) {
		 
		 List<Integer> ret = new ArrayList<>();
		 inOrder(root,ret);
		 return ret;
	 }
	 
	 private void inOrder(TreeNode n,List<Integer> result)
	 {
		 if (n != null) {
			 
			 if (n.left != null) {
				 inOrder(n.left, result);
			 }
			 
			 result.add(n.value);
			 
			 
			 if (n.right != null) {
				 inOrder(n.right, result);
			 }
		 }
	 }
	
	 
	 
	 public List<Integer> inorderTraversal_02(TreeNode root) {
		 
		 List<Integer> ret = new ArrayList<>();
		 if (root == null) return ret;

		 Stack<TreeNode> stack = new Stack<>();
		 
		 TreeNode curr = root;
		 
		 while(curr  != null || !stack.isEmpty()) {
			 
			 while(curr != null) {
				 stack.push(curr);
				 curr = curr.left;
			 }
			 
			 
			 curr = stack.pop();
			 ret.add(curr.value);
			 curr = curr.right;
		 }
		 
		 
		 return ret;
		 
	 }
	 
	 
	 
}
