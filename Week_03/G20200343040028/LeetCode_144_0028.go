package binary_tree_preorder_traversal

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
func preorderTraversal(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	result := make([]int, 0)
	stack := list.New()
	stack.PushBack(root)
	for stack.Len() > 0 {
		curr := stack.Back()
		stack.Remove(curr)
		treeNode := curr.Value.(*TreeNode)
		result = append(result, treeNode.Val)
		if treeNode.Right != nil {
			stack.PushBack(treeNode.Right)
		}
		if treeNode.Left != nil {
			stack.PushBack(treeNode.Left)
		}
	}
	return result
}
