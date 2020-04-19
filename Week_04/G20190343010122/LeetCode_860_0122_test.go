package homework

import "testing"

func Test_lemonadeChange(t *testing.T){
	input := []int{5,5,5,10,20}
	if !lemonadeChange(input){
		t.FailNow()
	}
	input = []int{5,5,10}
	if !lemonadeChange(input){
		t.FailNow()
	}
	input = []int{5,5,10,10,20}
	if lemonadeChange(input){
		t.FailNow()
	}
}
