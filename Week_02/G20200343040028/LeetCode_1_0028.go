package G20200343040028

func twoSum(nums []int, target int) []int {
	length := len(nums)
	if length < 2 {
		return nil
	}
	if length == 2 || nums[0]+nums[1] == target {
		return []int{0, 1}
	}
	hashTable := make(map[int]int, length)
	for i, v := range nums {
		if i < 2 {
			hashTable[v] = i
			continue
		}
		index, ok := hashTable[target-v]
		if ok {
			return []int{index, i}
		}
		hashTable[v] = i
	}
	return nil
}
func twoSum1(nums []int, target int) []int {
	if len(nums) == 2 || nums[0]+nums[1] == target {
		return []int{0, 1}
	}
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			if nums[i]+nums[j] == target {
				return []int{i, j}
			}
		}
	}
	return nil
}
