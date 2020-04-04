package G20200343040334

type Node struct {
	val      int
	children []*Node
}

func postorder(root *Node) []int {
	var res = make([]int, 0)
	helper(root, &res)
	return res
}

func helper(node *Node, res *[]int) {
	if node == nil {
		return
	}
	for _, v := range node.children {
		helper(v, res)
	}
	*res = append(*res, node.val)
}
