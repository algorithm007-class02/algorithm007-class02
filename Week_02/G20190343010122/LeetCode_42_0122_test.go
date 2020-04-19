package homework

import "testing"

func Test_trap(t *testing.T){
	input := []int{0,1,0,2,1,0,1,3,2,1,2,1}
	result := trap(input)
	if result != 6{
		t.Fail()
	}
}