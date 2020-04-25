func permute(nums []int) [][]int {
    ret := make([][]int, 0)
    backtrack(nums, nil, &ret)
    return ret
}

func backtrack(nums []int, prev []int, ret *[][]int) {
    if len(nums) == 1 {
        prev = append(prev, nums[0])
        tmp := make([]int, 0, len(prev))
        tmp = append(tmp, prev...)
        *ret = append(*ret, tmp)
        return
    }
    prevIndex := len(prev)
    prev = append(prev, -1)
    for i:=0; i<len(nums); i++ {
        prev[prevIndex] = nums[i]
        tmp := []int{}
        tmp = append(tmp, nums[:i]...)
        tmp = append(tmp, nums[i+1:]...)
        backtrack(tmp, prev[:prevIndex + 1], ret)
    }
}
