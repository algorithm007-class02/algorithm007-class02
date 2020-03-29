package g20200343040032

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(inorder) == 0 {
		return nil
	}
	idx := -1
	for i, v := range inorder {
		if v == preorder[0] {
			idx = i
		}
	}
	root := &TreeNode{Val: preorder[0]}
	root.Left = buildTree(preorder[1:idx+1], inorder[:idx])
	root.Right = buildTree(preorder[idx+1:], inorder[idx+1:])
	return root
}
