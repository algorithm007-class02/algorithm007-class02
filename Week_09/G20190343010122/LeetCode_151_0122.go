package homework

import (
	"container/list"
	"strings"
)

func reverseWords(s string) string {
	s = strings.TrimSpace(s)
	splitStrs := strings.Split(s, " ")
	stackList := list.New()
	for i:=0; i<len(splitStrs);i++ {
		trimedStr := strings.TrimSpace(splitStrs[i])
		if trimedStr != ""{
			stackList.PushBack(trimedStr)
		}
	}

	sb := strings.Builder{}

	for ; stackList.Len() != 0 ;  {
		v := stackList.Back()
		sb.WriteString(v.Value.(string))
		stackList.Remove(v)
		if stackList.Len() != 0{
			sb.WriteString(" ")
		}
	}

	return sb.String()
}

