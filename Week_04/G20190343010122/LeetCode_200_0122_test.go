package homework

import "testing"

/*
11110
11010
11000
00000
 */

func Test_numIslands(t *testing.T){
	grid := [][]byte{
		{'1','1','1','1','0'},
		{'1','1','0','1','0'},
		{'1','1','0','0','0'},
		{'0','0','0','0','0'},
	}

	if numIslands(grid) != 1{
		t.FailNow()
	}
}
