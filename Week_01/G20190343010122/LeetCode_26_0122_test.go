package homework

import "testing"

func Test_removeDuplicates(t *testing.T){
	input := []int{0,0,1,1,1,2,2,3,3,4}
	output := []int{0,1,2,3,4}

	len := removeDuplicates(input)
	for i:=0; i<len; i++ {
		if output[i] != input[i]{
			t.Fail()
		}
	}
}
