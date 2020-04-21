package homework


func maximalSquare(matrix [][]byte) int {
	if len(matrix) == 0 || len(matrix[0]) == 0{
		return 0
	}

	m := len(matrix)
	n := len(matrix[0])
	dp := make([][]int, m)
	for i:=0; i<m;i++{
		dp[i] = make([]int, n)
	}

	maxLength:=0
	for i:= 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if matrix[i][j] == '1' {
				if i == 0 || j == 0 {
					if matrix[i][j] == '1'{
						dp[i][j] = 1
					}else{
						dp[i][j] = 0
					}
				} else {
					dp[i][j] = minInt(dp[i - 1][j],
						minInt(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
				}

				maxLength = maxInt(dp[i][j], maxLength);
			}
		}
	}

	return maxLength * maxLength;
}

func minInt(lhs, rhs int)int{
	if lhs <= rhs{
		return lhs
	}
	return rhs
}

func maxInt(lhs, rhs int)int{
	if lhs >= rhs{
		return lhs
	}
	return rhs
}