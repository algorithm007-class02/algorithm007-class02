package G20200343040028

import "container/list"

type Node struct {
	Val      int
	Children []*Node
}

/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

func postorder(root *Node) []int {
	if root == nil {
		return []int{}
	}
	result := make([]int, 0)
	stack := list.New()
	stack.PushBack(root)
	for stack.Len() > 0 {
		curr := stack.Back()
		stack.Remove(curr)
		treeNode := curr.Value.(*Node)
		result = append(result, treeNode.Val)
		for _, node := range treeNode.Children {
			if node != nil {
				stack.PushBack(node)
			}
		}
	}
	return reverse(result)
}

func reverse(x []int) []int {
	for i, j := 0, len(x)-1; i < j; i, j = i+1, j-1 {
		x[i], x[j] = x[j], x[i]
	}
	return x
}
