func removeDuplicates(nums []int) int {
    var n = len(nums)
    if n <= 1 {
        return len(nums)
    }
    var i, j int
    var deletePos int
    for i = 0; i < n; i++ {
        if deletePos > 0 {
            nums[deletePos] = nums[i]
        }
        j = i + 1
        if j >= n {
            break
        }
        if nums[i] != nums[j] {
           deletePos++
        }
    }

    nums = nums[:deletePos+1]
    return len(nums)
}
