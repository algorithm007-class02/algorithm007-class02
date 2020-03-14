package homework

import (
	"fmt"
	"testing"
)

func Test_moveZeroes(t *testing.T){
//输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
	input := []int{0, 1, 0, 3, 12}
	output := []int{1, 3, 12, 0, 0}
	moveZeroes(input)

	fmt.Print(input)
	for i:=0; i<len(input);i++{
		if input[i] != output[i] {
			t.FailNow()
		}
	}
}
