package homework

import "testing"

func Test_robotSim(t *testing.T){
	command := []int{4, -1, 4, -2, 4}
	obstacles := [][]int{{2, 4}}
	if robotSim(command, obstacles) != 65{
		t.FailNow()
	}
}
