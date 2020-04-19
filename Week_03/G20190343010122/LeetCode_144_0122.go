package HomeWork

import "container/list"

func preorderTraversal(root *TreeNode) []int {
	stack := newStack()
	treeNode := root
	result := make([]int, 0)
	for ;treeNode != nil || !stack.Empty() ;  {
		// 迭代访问节点的左子节点,并入栈
		for ;treeNode != nil ;  {
			result = append(result, treeNode.Val)
			stack.Push(treeNode)
			treeNode = treeNode.Left
		}

		// 如果没有左子节点，则弹出栈顶节点，访问右节点。
		if !stack.Empty(){
			treeNode = stack.Pop().(*TreeNode)
			treeNode = treeNode.Right
		}
	}

	return result
}

// 用链表来模拟栈
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

