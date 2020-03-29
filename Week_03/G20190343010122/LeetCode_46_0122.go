package HomeWork

var result [][]int

func permute(nums []int) [][]int {
	result = [][]int{}

	ans := make([]int, 0)
	backtrack(nums, ans)

	return result
}

func backtrack(nums []int, ans []int) {
	if len(nums) == 0 {
		// 切片是指针，所以这里要复制下，被坑了一下
		copyAns := make([]int, 0)
		copyAns = append(copyAns, ans...)
		result = append(result, copyAns)
		return
	}

	for i := 0; i < len(nums); i++ {
		// 选择第i个元素
		val := nums[i]
		ans = append(ans, val)
		// 传到进下一层
		nums = append(nums[:i], nums[i+1:]...)
		backtrack(nums, ans)

		// 撤销选择
		ans = ans[:len(ans)-1]

		// 把删掉的元素，放回原位置
		nums = append(nums[:i], append([]int{val}, nums[i:]...)...)

	}
}

