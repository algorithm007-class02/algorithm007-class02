package main

import "fmt"
// https://leetcode-cn.com/problems/repeated-dna-sequences/
/**
187. 重复的DNA序列
所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。



示例：

输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC", "CCCCCAAAAA"]
 */
func main() {
	fmt.Println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
}

func findRepeatedDnaSequences(s string) []string {
	subMap := map[string]bool{}
	existMap := map[string]bool{}
	var res []string
	for i := 0; i < len(s)-10; i++ {
		subs := s[i : i+10]
		if subMap[subs] && !existMap[subs] {
			existMap[subs] = true
			res = append(res, subs)
		} else {
			subMap[subs] = true
		}
	}
	return res
}
