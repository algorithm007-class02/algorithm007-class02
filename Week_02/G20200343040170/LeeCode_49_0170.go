func groupAnagrams(strs []string) [][]string {
    store := make(map[string][]string, len(strs))
    var key string
    for _, str := range strs {
        ss := []byte(str)
	    sort.Slice(ss, func(i, j int) bool { return ss[i] < ss[j] })
        key = string(ss)
        if _, ok := store[key]; ok {
            store[key] = append(store[key], str)
        } else {
            store[key] = []string{str}
        }
    }

    arrs := make([][]string, 0, len(store))
    for i := range store {
        arrs = append(arrs, store[i])
    }

    return arrs 
}
