func combine(n int, k int) [][]int {
	res := make([][]int, 0, k*n)
	helper(&res, nil, 1, n, k)
	return res
}

func helper(res *[][]int, data []int, i, n, k int) {
	if len(data) == k {
		*res = append(*res, data)
		return
	}
	for i := i; i <= n; i++ {
		tmp := make([]int, 0, k)
        if len(data) > 0 {
            tmp = append(tmp ,data...)
        }
		tmp = append(tmp, i)
		helper(res, tmp, i+1, n, k)
	}
}
