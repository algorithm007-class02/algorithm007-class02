package main

import "fmt"

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串

func main() {
	fmt.Println(groupAnagram([]string{"eat", "tea", "tan", "ate", "nat", "bat"}))
}

// 每个字符串遍历组成一个唯一的指数下标
// hash得到key 判断是否存在
// 如果不存在则初始化，否则append
func groupAnagram(strs []string) [][]string {
	cnt := 0
	prime := []int{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103}   // 用26个质数代表26个字母
	hash := map[int]int{}
	var ans [][]string
	for _, s := range strs{
		t := 1
		for _,v := range s{
			t *= prime[v - 'a']
		}
		if _,ok := hash[t]; !ok{
			hash[t] = cnt
			ans = append(ans, []string{})
			ans[cnt] = []string{}
			cnt ++
		}
		ans[hash[t]] = append(ans[hash[t]], s)
	}
	return ans
}
