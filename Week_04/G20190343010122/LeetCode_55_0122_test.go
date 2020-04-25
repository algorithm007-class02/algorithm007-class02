package homework

import "testing"

func Test_canJump(t *testing.T){

	if canJump([]int{2,3,1,1,4}) != true{
		t.FailNow()
	}

	if canJump([]int{3,2,1,0,4}) == true{
		t.FailNow()
	}

}

