package homework

import "strings"

func reverseWords(s string) string {
	splitedStr := strings.Split(s, " ")
	sb := strings.Builder{}
	for i:=0; i<len(splitedStr);i++  {
		bytes := []byte(splitedStr[i])
		l:=0
		r:=len(bytes)-1
		for ;l<r;  {
			bytes[l],bytes[r] = bytes[r], bytes[l]
			l++
			r--
		}

		sb.Write(bytes)
		if i < len(splitedStr)-1{
			sb.WriteString(" ")
		}
	}
	return sb.String()
}
