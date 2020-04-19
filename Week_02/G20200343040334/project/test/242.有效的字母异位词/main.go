package main

import "fmt"

/**
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
func isAnagram(s string, t string) bool {

}
//leetcode submit region end(Prohibit modification and deletion)

 */
func main() {
	//res := isAnagram1("awdwwq", "awdqww")
	res := isAnagram2("awdwwq", "awdqww")
	fmt.Println(res)
}

/**
	2个数组，存放2个字符串的出现的次数
	存在就+1
	比较数组是否等
 */
func isAnagram1(s , t string) bool {
	a := [26]int{}
	b := [26]int{}
	for _, v := range s{
		a[v-'a'] += 1
		fmt.Println(" v :", v, " v-a ", v - 'a')
	}
	for _, v := range t{
		b[v-'a'] += 1
	}
	return a == b
}

/**
	1个数组，存放字符串26字母
	出现在s字符+1
	出现在t字符-1
	遍历每个元素是否等0
 */
func isAnagram2(s, t string) bool {
	a := [26]int{}
	for _, v := range s {
		a[v-'a']++
	}
	for _, v := range t {
		a[v-'a']--
	}
	for _, v := range a {
		if v != 0{
			return false
		}
	}
	return true
}
