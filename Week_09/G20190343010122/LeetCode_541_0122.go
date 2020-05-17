package homework

func reverseStr(s string, k int) string {
	if k == 1{
		return s
	}


	bytes := []rune(s)
	sLenth := len(bytes)
	if k > sLenth{
		reverseSubStr(bytes, 0, sLenth-1)
		return string(bytes)
	}

	for start := 0; start < sLenth; start += k*2 {
		if start+k < sLenth {
			reverseSubStr(bytes, start, start+k-1)
		} else {
			reverseSubStr(bytes, start, sLenth-1)
		}
	}


	return string(bytes)
}

func reverseSubStr( s []rune, start, end int){
	left := start
	right := end
	for ; left<right;{
		s[left], s[right] = s[right], s[left]
		left++
		right--
	}
}
