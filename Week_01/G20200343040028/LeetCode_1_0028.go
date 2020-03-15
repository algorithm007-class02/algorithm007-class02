package G20200343040028


func twoSum(nums []int, target int) []int {
	length := len(nums)
	// if length < 2 {
	// 	return nil
	// }
	// if length == 2 || nums[0]+nums[1] == target {
	// 	return []int{0, 1}
	// }
	hashTable := make(map[int]int, length)
	for i, v := range nums {
		if i < 1 {
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