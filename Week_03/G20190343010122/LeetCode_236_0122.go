package HomeWork

import "container/list"

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil || root == p || root == q{
		return root
	}

	left := lowestCommonAncestor(root.Left,p, q)
	right := lowestCommonAncestor(root.Right, p, q)

	if left == nil && right == nil{
		return nil
	}

	if left !=nil && right != nil{
		return root
	}

	if left == nil{
		return right
	} else {
		return left
	}
}
