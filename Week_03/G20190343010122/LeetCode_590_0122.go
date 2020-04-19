package HomeWork

func postorder(root *Node) []int {
	if root == nil{
		return []int{}
	}

	result := make([]int, 0)

	for i:=0; i<len(root.Children);i++ {
		result = append(result, postorder(root.Children[i])...)
	}

	result = append(result, root.Val)

	return result
}
