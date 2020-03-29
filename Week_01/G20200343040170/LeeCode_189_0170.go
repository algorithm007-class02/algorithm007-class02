func rotate(nums []int, k int) {
    if k == 0 {
        return
    }
    if len(nums) <= 1 {
        return
    }
    k = k % len(nums)
    reverse(nums)
    reverse(nums[:k])
    reverse(nums[k:])
}

func reverse(nums []int) {
    var j int
    n := len(nums)
    for i := 0; i < n; i++ {
        j = n - i - 1
        if i >= j {
            break
        }
        nums[i], nums[j] = nums[j], nums[i]
    }
}
