func reverseWords(s string) string {
    arr := strings.Split(s, " ")
    sn := make([]string, 0, len(arr))
    for i := range arr {
        sn = append(sn, reverse([]byte(arr[i])))
    }
    return strings.Join(sn, " ")
}

func reverse(s []byte) string {
    low := 0
    high:= len(s) - 1
    for low < high {
        s[low], s[high] = s[high], s[low]
        low++
        high--
    }
    return string(s)
}