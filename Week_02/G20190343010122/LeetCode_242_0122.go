package homework


func isAnagram(s string, t string) bool {

	sLen := len(s)
	tLen := len(t)

	if sLen != tLen{
		return false
	}

	counter := make([]int, 26)

	// 遍历，向统计器中，一个+1，一个-1
	for i:=0; i<sLen; i++{
		counter[s[i] - 'a']++
		counter[t[i] - 'a']--
	}

	// 如果两个字符串为异位次，则应该上面两个循环执行完后，数组中的虽有元素，皆为0
	for i:=0; i<26; i++ {
		if counter[i] != 0{
			return false
		}
	}

	return true
}
