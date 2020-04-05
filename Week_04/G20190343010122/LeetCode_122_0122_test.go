package homework

import "testing"

func Test_maxProfit(t *testing.T){
	input := []int{7,1,5,3,6,4}
	if 7 != maxProfit(input){
		t.FailNow()
	}

	input = []int{1,2,3,4,5}
	if 4 != maxProfit(input){
		t.FailNow()
	}
}
