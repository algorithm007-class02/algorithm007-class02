
package homework

import (
	"testing"
)

func Test_mergeTwoLists(t *testing.T){

	l1Elements := []int{1,2,4}

	l1 := &ListNode{}
	l1.Val = l1Elements[0]
	l1Cur := l1
	for i:=1; i<len(l1Elements); i++  {
		node := &ListNode{}
		node.Val = l1Elements[i]
		l1Cur.Next = node
		l1Cur = node
	}

	l2Elements := []int{1,3,4}
	l2 := &ListNode{}
	l2.Val = l2Elements[0]
	l2Cur := l2
	for i:=1; i<len(l2Elements); i++  {
		node := &ListNode{}
		node.Val = l2Elements[i]
		l2Cur.Next = node
		l2Cur = node
	}

	result := mergeTwoLists(l1, l2)


	l3Elements := []int{1,1,2,3,4}
	l3 := &ListNode{}
	l3.Val = l3Elements[0]
	l3Cur := l3
	for i:=1; i<len(l3Elements); i++  {
		node := &ListNode{}
		node.Val = l3Elements[i]
		l3Cur.Next = node
		l3Cur = node
	}

	resultCur := result
	targetCur := l3
	for ; resultCur != nil && targetCur  != nil;  {
		if resultCur.Val != targetCur.Val{
			t.Fail()
		}
		resultCur = resultCur.Next
		targetCur = targetCur.Next
	}
}