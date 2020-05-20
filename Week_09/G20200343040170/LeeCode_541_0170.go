func reverseStr(s string, k int) string {
    if len(s) == 0 {
        return s
    }

    arr := make([][]byte, 0, len(s)/k+1)
    arr = append(arr, []byte{})
    ki := 0
    for i := 0; i < len(s); i++ {
        if i > 0 && i % k == 0 {
            ki++
            arr = append(arr, []byte{})
        }
        arr[ki] = append(arr[ki], s[i])
    }

    sn := make([]byte, 0, len(s))
    for i := range arr {
        if i % 2 == 0 {
           sb := reverse([]byte(arr[i]))
            sn = append(sn, sb...)
            fmt.Println(arr[i])
        } else {
            sn = append(sn, []byte(arr[i])...)
        }
    }

    return string(sn)
}

func reverse(s []byte) []byte {
    if len(s) == 0 {
        return s
    }
    low  := 0
    high := len(s) - 1
    for low < high {
        s[low], s[high] = s[high], s[low]
        low++
        high--
    }

    return s
}