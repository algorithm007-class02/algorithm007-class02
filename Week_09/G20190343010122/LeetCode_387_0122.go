package homework


func firstUniqChar(s string) int {
	letterArray := [26]int{}

	for i:=0; i<len(s); i++ {
		letterArray[s[i]-'a']++
	}

	for i:=0;i<len(s) ; i++ {
		if letterArray[s[i]-'a'] == 1{
			return i
		}
	}

	return -1
}
