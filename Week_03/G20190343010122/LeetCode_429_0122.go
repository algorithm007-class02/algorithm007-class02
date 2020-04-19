package HomeWork

import "container/list"

func levelOrder(root *Node) [][]int {
	if root == nil{
		return [][]int{}
	}
	result := make([][]int, 0)
	list := list.New()
	list.PushBack(root)
	for ;list.Len() != 0;  {
		curLevel := make([]int, 0)
		curLevNodeCount := list.Len()
		for i:=0; i<curLevNodeCount; i++  {
			treeNode := list.Front().Value.(*Node)
			list.Remove(list.Front())
			curLevel = append(curLevel, treeNode.Val)
			for i:=0; i< len(treeNode.Children); i++{
				list.PushBack(treeNode.Children[i])
			}
		}

		result = append(result, curLevel)
	}

	return result
}
