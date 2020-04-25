package main

type linkTable struct {
	Head  *linkTable
	Value int
	Next  *linkTable
}


/*
删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：给定一个链表: 1->2->3->4->5, 和 n = 2.当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
func main() {
	removeNthFromEnd(&linkTable{}, 2)
}

func removeNthFromEnd(head *linkTable, n int) *linkTable{
	start := head
	pre := head
	end := head
	for n != 0{
		start = start.Next
		n --
	}
	for start.Next != nil{
		start = start.Next
		end = end.Next
	}
	end.Next = end.Next.Next
	return pre
}
