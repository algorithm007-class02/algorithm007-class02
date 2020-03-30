package G20200343040028

import "container/list"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderTraversal(root *TreeNode) []int {
	result := make([]int, 0)
	stack := list.New()
	curr := root
	for curr != nil || stack.Len() > 0 {
		for curr != nil {
			stack.PushBack(curr)
			curr = curr.Left
		}
		top := stack.Back()
		stack.Remove(top)
		result = append(result, top.Value.(*TreeNode).Val)
		curr = top.Value.(*TreeNode).Right
	}
	return result
}
