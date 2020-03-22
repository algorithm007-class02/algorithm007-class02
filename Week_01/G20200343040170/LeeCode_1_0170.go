func twoSum(nums []int, target int) []int {
    m := make(map[int]int, 2)
    for i := 0; i < len(nums); i++ {
        if k, ok := m[nums[i]]; ok {
            return []int{k, i}
        }
        m[target - nums[i]] = i
    }
    return nil
}
