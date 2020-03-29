package HomeWork

// 选过就不能再选了

var result [][]int
func combine(n int, k int) [][]int {
	result := make([][]int , 0)
	ans := make([]int, 0)
	backtrack(1, n, k, ans)

	return result
}

func backtrack(start, end int, k int, ans []int) {
	if len(ans) == k {
		copyAns := make([]int, 0)
		copyAns = append(copyAns, ans...)
		result = append(result, copyAns)
		return
	}

	for i := start; i <= end; i++ {
		// 选择i
		ans = append(ans, i)
		backtrack(i+1, end, k, ans)
		// 撤销选择i
		ans = ans[:len(ans)-1]
	}
}
