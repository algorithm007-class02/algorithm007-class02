package n_ary_tree_level_order_traversal

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

var ans [][]int

func levelOrder(root *Node) [][]int {
	ans = make([][]int, 0)
	if root != nil {
		traverseNode(root, 0)
	}
	return ans
}

func traverseNode(node *Node, level int) {
	if len(ans) <= level {
		ans = append(ans, make([]int, 0))
	}
	ans[level] = append(ans[level], node.Val)
	for _, v := range node.Children {
		if v == nil {
			continue
		}
		traverseNode(v, level+1)
	}
}
