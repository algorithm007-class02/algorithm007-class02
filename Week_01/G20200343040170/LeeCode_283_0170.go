func moveZeroes(nums []int)  {
    var p = 0
    for i:=0; i<len(nums); i++ {
        if nums[i] != 0 {
            nums[p], nums[i] = nums[i], nums[p]
            p++
        }
    }
}
