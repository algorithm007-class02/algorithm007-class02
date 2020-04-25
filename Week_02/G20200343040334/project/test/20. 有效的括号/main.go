package main

import "fmt"

func main() {
	//s:= "({((())))"
	s:= "(((())))"
	isValid := isValid(s)
	fmt.Println(isValid)
}
// 解题思路：
// 定义map dict := map[byte]byte{'(':')','{':'}','[':']'}
// 定义stack数组
// 循环遍历
// if stack为空则判断最后的元素和当前字符在map中是否存在  如果存在则出栈，不存在则继续入栈
func isValid(s string) bool {
	dict := map[byte]byte{'(':')','{':'}','[':']'}
	var stack []byte
	for _,v := range s{
		if len(stack) > 0{
			if byte(v) == dict[stack[len(stack)-1]]{
				stack = stack[:len(stack)-1]
				continue
			}
		}
		stack = append(stack, byte(v))
		fmt.Println(stack)
	}
	return len(stack)<1
}
