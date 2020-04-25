package G20200343040334

type TreeNode struct {
	Left  *TreeNode
	Right *TreeNode
	Val   *TreeNode
}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {

	if root == p || root == q || root == nil {
		return root
	}
	l := lowestCommonAncestor(root.Left, p, q)
	r := lowestCommonAncestor(root.Right, p, q)
	if l != nil && r != nil {
		return root
	} else if l != nil {
		return l
	} else if r != nil {
		return r
	}
	return nil
}
