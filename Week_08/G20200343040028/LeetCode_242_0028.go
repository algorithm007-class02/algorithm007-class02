package G20200343040028

import "fmt"

// 2. 使用哈希表记录字母出现情况。考虑unicode字符，用数组已经不合适，占内存太大，直接用通用哈希表
//34/34 cases passed (8 ms)
//Your runtime beats 68.7 % of golang submissions
//Your memory usage beats 75.19 % of golang submissions (3 MB)
func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	// 由于哈希表起始长度为0，所以需要截住 "" == "" 的特殊情况
	if len(s) == 0 {
		return true
	}

	// “哈希表”
	words := make(map[rune]int)	// rune在go中是int32别名，任何UTF-8编码（变长）的字符都可以直接用它表示（定长）

	fmt.Println("word s...")

	// 填充哈希表元素（字母出现的次数）
	for _, v := range s {
		words[v]++
		fmt.Printf("words[%v]=%d\n", v, words[v])
	}

	fmt.Println("word t...")

	// 减去哈希表元素，当为0时删除键
	for _, v := range t {
		words[v]--
		fmt.Printf("words[%v]=%d\n", v, words[v])
		if words[v] == 0 {
			delete(words, v)
		}
	}

	fmt.Printf("words=%v\n", words)

	// 判断哈希表是否为空	// 注意! map==nil和len(map)==0是两个概念！我们把所有键删除了，最后map就为空
	if len(words) == 0 {
		return true
	}

	return false
}