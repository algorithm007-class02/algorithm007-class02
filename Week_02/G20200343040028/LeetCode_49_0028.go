package G20200343040028

import "sort"

func groupAnagrams(strs []string) [][]string {
	if strs == nil || len(strs) == 0 {
		return [][]string{}
	}
	rMap := make(map[string][]int, 0)
	for i, v := range strs {
		str := aSort(v)
		if _, ok := rMap[str]; !ok {
			rMap[str] = []int{i}
		} else {
			rMap[str] = append(rMap[str], i)
		}
	}
	res := make([][]string, 0)
	for _, v := range rMap {
		a := make([]string, 0)
		for _, x := range v {
			a = append(a, strs[x])
		}
		res = append(res, a)
	}
	return res
}

func aSort(s string) string{
	x := []byte(s)
	sort.Slice(x, func(i, j int) bool {return x[i] < x[j]})
	return string(x)
}
