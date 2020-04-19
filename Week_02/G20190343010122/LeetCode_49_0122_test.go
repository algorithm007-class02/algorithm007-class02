package homework

import (
	"fmt"
	"testing"
)

func Test_groupAnagrams(t *testing.T){
	input := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	result := groupAnagrams(input)

	// 预期的结果为
	//[["bat"],["nat","tan"],["ate","eat","tea"]]
	fmt.Println(result)
}
