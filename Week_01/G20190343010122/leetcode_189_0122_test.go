package homework

import "testing"

func Test_rotate(t *testing.T){
	input := []int{1,2,3,4,5,6,7}
	k :=3
	expectOutput := []int{5,6,7,1,2,3,4}
	rotate(input, k)

	for i:=0; i < len(input); i++ {
		if input[i] != expectOutput[i]{
			t.Fail()
		}
	}
}
