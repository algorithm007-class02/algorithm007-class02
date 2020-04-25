package homework

import "testing"

func Test_search(t *testing.T){
	output := search([]int{3,1}, 1)
	if output != 1{
		t.FailNow()
	}

	output = search([]int{4,5,6,7,0,1,2,3}, 0)
	if output != 4{
		t.FailNow()
	}
}