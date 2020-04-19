package homework

import "testing"

func Test_findContentChildren(t *testing.T){

	if findContentChildren([]int{1,2,3}, []int{1,1}) != 1{
		t.FailNow()
	}

	if findContentChildren([]int{1,2},[]int{1,2,3}) != 2{
		t.FailNow()
	}
}
