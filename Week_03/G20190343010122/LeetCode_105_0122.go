package HomeWork


var inOrderMap map[int]int

func buildTree(preorder []int, inorder []int) *TreeNode {
	inOrderMap = make(map[int]int, 0)

	for i:=0;i< len(inorder) ;i++  {
		inOrderMap[inorder[i]] = i
	}

	return buildHelp(preorder, 0, len(preorder) -1, inorder, 0, len(inorder))
}

func buildHelp(preOrder []int, preStart, preEnd int, inOrder[]int, inStart, inEnd int)*TreeNode{
	if preStart > preEnd || inStart > inEnd{
		return nil
	}

	root := &TreeNode{Val:preOrder[preStart]} // 前序遍历是中，左，右，因此直接确认root节点
	indexInOrder := inOrderMap[root.Val] // 中序遍历的顺序是左，中，右，因此我们可以求出左右子树的数量，进一步求出在前序遍历中的位置

	// index左边的是左子树，右边的是右子树
	root.Left = buildHelp(preOrder, preStart+1, preEnd, inOrder, inStart, indexInOrder-1)
	// 通过root在中序遍历中的位置，可以求出root的左子树的节点数量。用这个节点数量，可以推算出在当根节点在前序遍历中的右子树位置
	// 因此右子树的开始位置是preStart+indexInorder-inStart+1
	root.Right = buildHelp(preOrder, preStart+indexInOrder-inStart+1, preEnd, inOrder, indexInOrder+1, inEnd)

	return root
}
