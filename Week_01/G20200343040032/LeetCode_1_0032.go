package g20200343040032

func twoSum(nums []int, target int) []int {
	// map类型变量
	m := map[int]int{}
	for i, v := range nums {
		if k, ok := m[target-v]; ok {
			return []int{k, i}
		}
		m[v] = i
	}
	return nil
}
