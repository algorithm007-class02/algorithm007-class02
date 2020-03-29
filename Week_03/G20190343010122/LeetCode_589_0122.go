package HomeWork

func preorder(root *Node) []int {
	if root == nil{
		return []int{}
	}

	result := make([]int, 0)
	result = append(result, root.Val)
	for i:=0; i<len(root.Children); i++  {
		result = append(result, preorder(root.Children[i])...)
	}

	return result
}
