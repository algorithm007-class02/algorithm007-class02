package homework

import "testing"

func Test_plusOne(t *testing.T){

	input := []int{9,9,9,9}
	output := []int{1,0,0,0,0}
	result := plusOne(input)
	for i:=0; i<len(output) ; i++ {
		if result[i] != output[i]{
			t.Fail()
		}
	}

	input = []int{0}
	output = []int{1}
	result = plusOne(input)
	for i:=0; i<len(output) ; i++ {
		if result[i] != output[i]{
			t.Fail()
		}
	}
}
