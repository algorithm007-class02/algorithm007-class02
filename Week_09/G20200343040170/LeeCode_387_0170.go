func firstUniqChar(s string) int {
    arr := make([]int, 256)
    for _, c := range s {
        arr[c] += 1
    }
    for i, c := range s {
        if arr[c] == 1 {
            return i
        }
    }

    return -1
}