package main

import "fmt"

func main() {
	board := [][]string{{".", ".", ".", ".", ".", ".", ".", "."},
		{".", ".", ".", "P", ".", ".", ".", "."},
		{".", ".", ".", "R", ".", ".", ".", "P"},
		{".", ".", ".", ".", ".", ".", ".", "."},
		{".", ".", ".", "B", ".", ".", ".", "."},
		{".", ".", ".", "P", ".", ".", ".", "."},
		{".", ".", ".", ".", ".", ".", ".", "."},
		{".", ".", ".", ".", ".", ".", ".", "."}}

	fmt.Println(numRookCaptures(board))
}

func numRookCaptures(board [][]string) int {
	res := 0
	directions := [][]int{{-1, 0}, {1, 0}, {0, 1}, {0, -1}}
	for i := 0; i < 8; i++ {
		for j := 0; j < 8; j++ {
			if board[i][j] == "R" {
				for _, v := range directions {
					if burnout(board, i, j, v) {
						res++
					}
				}
				return res
			}
		}
	}
	return res
}

func burnout(board [][]string, x, y int, direction []int) bool {
	i, j := x, y
	for inArea(i, j) {
		if board[i][j] == "B" {
			break
		}
		if board[i][j] == "P" {
			return true
		}
		i += direction[0]
		j += direction[1]
	}
	return false
}

func inArea(x, y int) bool {
	return x >= 0 && x < 8 && y >= 0 && y < 8
}


