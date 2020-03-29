package g20200343040032

var table []string = []string{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}

func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}
	result := []string{""}

	for i := 0; i < len(digits); i++ {
		t := table[digits[i]-'0']
		temp := []string{}
		for j := 0; j < len(t); j++ {
			for z := 0; z < len(result); z++ {
				temp = append(temp, result[z]+string([]byte{t[j]}))
			}
		}
		result = temp
	}

	return result
}
