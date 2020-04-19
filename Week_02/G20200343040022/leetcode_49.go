func groupAnagrams(strs []string) [][]string {
	mapdata := make(map[string][]string)
	for _, str := range strs {
		b := []byte(str)
		sort.Slice(b, func(i, j int) bool {
			return b[i] < b[j]
		})
		index := string(b)
		mapdata[index] = append(mapdata[index], str)
	}

	ret := make([][]string, 0, len(mapdata))
	for _, v := range mapdata {
		ret = append(ret, v)
	}
	return ret
}
