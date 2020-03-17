package homework

func reverse(nums []int, start, end int){
	for ; start < end ;  {
		nums[start],nums[end] = nums[end], nums[start]
		start++
		end--
	}
}

func rotate(nums []int, k int)  {
	len := len(nums)
	if len == 1{
		return
	}

	k %= len

	reverse(nums, 0, len-1)
	reverse(nums, 0, k-1)
	reverse(nums, k, len-1)
}