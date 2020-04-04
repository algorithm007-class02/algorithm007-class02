package main

import (
	"fmt"
	"math/rand"
)

func main() {
	head := ListNode{}
	for k, v := range rand.Perm(10) {
		head.value = v
		head.next = &ListNode{}
		fmt.Println("k ", k, " v ", v)
	}
	for {
		if head.next == nil{
			break
		}
		head = *head.next
		fmt.Println(head.next)
	}
}

type ListNode struct {
	next  *ListNode
	value int
}

func middleNode(head *ListNode) *ListNode {
	for font := head; head != nil && head.next != nil; font, head = font.next.next, head.next {}
	return head
}

func middleNode2(head *ListNode) *ListNode {
	fast, slow := head, head
	for {
		if fast.next != nil && fast.next.next != nil {
			fast = fast.next.next
			slow = slow.next
		} else if fast.next != nil {
			return slow.next
		} else {
			return slow
		}
	}
}
