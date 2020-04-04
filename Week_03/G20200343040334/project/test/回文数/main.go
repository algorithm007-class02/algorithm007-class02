package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	//fmt.Println(isPalindrome(123321))
	//fmt.Println(isPalindrome(12321))
	//fmt.Println(isPalindrome(122321))
	fmt.Println(isPalindrome(1234321))
}

func isPalindrome(x int) bool {
	s := strconv.Itoa(x)
	ss := strings.Split(s, "")
	slen := len(ss)
	for i := 0; i < slen/2; i++ {
		fmt.Println(ss[i], "   ", ss[slen-i-1])
		if ss[i] != ss[slen-i-1]{
			return false
		}
	}
	return true
}
