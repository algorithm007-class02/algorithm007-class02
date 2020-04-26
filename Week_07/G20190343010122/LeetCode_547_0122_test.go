package homework

import "testing"

func Test_friendCirclesNum(t *testing.T){
	m := [][]int{
		{1,1,0},
		{1,1,0},
		{0,0,1}}

	if findCircleNum(m) != 2{
		t.FailNow()
	}
}
