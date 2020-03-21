package homework

import "sort"

type stringSorter []rune

func (s stringSorter)Len()int{
	return len(s)
}

func (s stringSorter)Less(i,j int) bool{
	return s[i] < s[j]
}

func (s stringSorter)Swap(i,j int){
	s[i],s[j] = s[j],s[i]
}

func groupAnagrams(strs []string)[][]string{
	result := make([][]string, 0)
	anagramMap := make(map[string][]string, 0)

	for i:=0; i<len(strs); i++ {
		unsortedRune := []rune(strs[i])
		sort.Sort(stringSorter(unsortedRune))
		sortedStr := string(unsortedRune)
		v, ok := anagramMap[sortedStr]
		if ok{
			v = append(v, strs[i])
			anagramMap[sortedStr] = v
		} else {
			anagramMap[sortedStr] = []string{strs[i]}
		}
	}

	for _,v := range anagramMap  {
		result = append(result, v)
	}

	return result
}
