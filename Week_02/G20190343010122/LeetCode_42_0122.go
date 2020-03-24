package homework

import "container/list"


func trap(height []int) int {
	allWaters := 0
	stack := newStack()

	for i:=0; i<len(height) ; i++{
		for ;!stack.Empty() && height[stack.Top()] < height[i];  {
			bottomHeight := height[stack.Pop()]
			if stack.Empty(){
				break
			}

			waterHeight := min(height[stack.Top()], height[i]) - bottomHeight
			allWaters += waterHeight * (i - stack.Top() - 1)
		}
		stack.Push(i)
	}

	return allWaters
}


// 基于链表实现的栈
type Stack struct{
	list *list.List
}

func newStack()*Stack{
	this := &Stack{}
	this.list = list.New()
	return this
}

func (this *Stack)Top()int{
	return this.list.Back().Value.(int)
}

func (this *Stack)Push(value int){
	this.list.PushBack(value)
}

func (this *Stack)Pop()int{
	back := this.list.Back().Value.(int)
	this.list.Remove(this.list.Back())
	return back
}

func (this *Stack)Empty()bool{
	return this.list.Len() == 0
}

func min(lhs, rhs int) int{
	if lhs < rhs{
		return lhs
	}

	return rhs
}