package homework

var gridWidth int
var gridHeight int

func numIslands(grid [][]byte) int {
	count := 0
	gridHeight = len(grid)
	if gridHeight == 0{
		return count
	}
	gridWidth = len(grid[0])


	for i:=0; i<gridHeight; i++ {
		for j:=0; j<gridWidth;j++  {
			if grid[i][j] == '1'{
				dfs(grid,i,j)
				count++
			}
		}
	}

	return count
}

func dfs(grid [][]byte, row, col int){
	if row<0 || col<0 || row>=gridHeight || col>=gridWidth || grid[row][col] == '0'{
		return
	}
	grid[row][col] = '0'
	dfs(grid, row-1, col)
	dfs(grid, row+1, col)
	dfs(grid, row, col-1)
	dfs(grid, row, col+1)
}

