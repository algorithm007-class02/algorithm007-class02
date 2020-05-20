func reverseOnlyLetters(S string) string {
	sb := []byte(S)
	low := 0
	high := len(sb) - 1
	for low < high {
		for !isCharacter(sb[low]) && low < high {
			low++
		}
		for !isCharacter(sb[high]) && low < high {
			high--
		}
		sb[low], sb[high] = sb[high], sb[low]
		low++
		high--
	}

	return string(sb)
}

func isCharacter(b byte) bool {
	if (b >= 'a' && b <= 'z') || (b >= 'A' && b <= 'Z') {
		return true
	}
	return false
}