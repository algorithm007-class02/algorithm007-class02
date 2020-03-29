package G20200343040028

// 可以利用两个长度都是26的字符串数组，
// 统计每个字符串中小写字母出现的次数，
// 然后再对比是否相等
func isAnagram(s string, t string) bool {
	a := [26]int{}
	b := [26]int{}

	for _, v := range s {
		a[v-'a'] += 1
	}

	for _, v := range t {
		b[v-'a'] += 1
	}

	return a == b
}
