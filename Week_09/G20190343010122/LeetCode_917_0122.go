package homework

func reverseOnlyLetters(S string) string {
	bytes := []byte(S)
	left := 0
	right := len(bytes)-1
	for ;left < right ;  {

		if isLetter(bytes[left]) && isLetter(bytes[right]){
			bytes[left], bytes[right] = bytes[right],bytes[left]
			left++
			right--
		}else if !isLetter(bytes[left]){
			left++
		}else if !isLetter(bytes[right]){
			right--
		}
	}

	return string(bytes)
}

func isLetter(b byte)bool{
	if b >= 'a' && b<='z' || b>='A' && b<='Z'{
		return true
	}
	return false
}

