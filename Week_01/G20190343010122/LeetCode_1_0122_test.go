package homework

import (
	"fmt"
	"testing"
)

func Test_twoSum(t *testing.T){
	// 输入nums = [2, 7, 11, 15]， target = 9
	// 期待的输出 result = [0, 1]

	input := []int{2, 7, 11, 15}
	result := []int{0, 1}

	output := twoSum(input, 9)
	fmt.Println("output:", output)
	fmt.Println("expect:", result)
	for i:=0; i<len(result); i++{
		if result[i] != output[i]{
			t.Fail()
		}
	}

}
