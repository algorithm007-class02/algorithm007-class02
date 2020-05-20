package homework

func isIsomorphic(s string, t string) bool {
	if len(s)==0 && len(t)==0{
		return true
	}

	if len(s) != len(t){
		return false
	}

	return isIsomorphicHelp(s, t) && isIsomorphicHelp(t, s)
}

func isIsomorphicHelp(s string, t string)bool{
	charMap := make(map[byte]byte, 0)
	for i:=0; i<len(s); i++ {
		if v, ok := charMap[s[i]]; ok{
			if v != t[i]{
				return false
			}

		}else {
			charMap[s[i]] = t[i]
		}
	}

	return true
}
