package HomeWork

import "container/list"

// 中序遍历的顺序是 左孩子，根，右
func inorderTraversal(root *TreeNode) []int {
	stack := newStack()
	result := make([]int, 0)
	treeNode := root

	for ;treeNode!= nil || !stack.Empty() ;  {
		for ; treeNode != nil;  {
			stack.Push(treeNode)
			treeNode = treeNode.Left
		}

		if !stack.Empty(){
			treeNode = stack.Pop().(*TreeNode)
			result = append(result, treeNode.Val)
			treeNode = treeNode.Right
		}
	}

	return result
}

type Stack struct{
	list *list.List
}

func newStack()*Stack{
	this := &Stack{}
	this.list = list.New()
	return this
}

func (this *Stack)Top()interface{}{
	return this.list.Back().Value
}

func (this *Stack)Push(value interface{}){
	this.list.PushBack(value)
}

func (this *Stack)Pop()interface{}{
	back := this.list.Back().Value
	this.list.Remove(this.list.Back())
	return back
}

func (this *Stack)Empty()bool{
	return this.list.Len() == 0
}
