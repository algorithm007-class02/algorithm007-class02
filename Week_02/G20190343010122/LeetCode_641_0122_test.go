package homework

import (
	"testing"
)

func Test_MyCircularDeque(t *testing.T) {
	circularDeque := Constructor(3) // 设置容量大小为3
	if !circularDeque.InsertLast(1){ // 返回 true
		t.Fail()
	}
	if !circularDeque.InsertLast(2){
		t.Fail()
	}
	// 返回 true
	if !circularDeque.InsertFront(3){// 返回 true
		t.Fail()
	}
	if circularDeque.InsertFront(4){ //已经满了，返回 false
		t.Fail()
	}
	if circularDeque.GetRear() != 2{ 	// 返回 2
		t.Fail()
	}
	if !circularDeque.IsFull(){  // 返回true
		t.Fail()
	}
	if !circularDeque.DeleteLast(){ // 返回true
		t.Fail()
	}
	if !circularDeque.InsertFront(4){  // 返回true

	}
	if circularDeque.GetFront() != 4{  // 应该返回4
		t.Fail()
	}
}