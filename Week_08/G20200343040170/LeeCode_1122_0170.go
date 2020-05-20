func relativeSortArray(arr1 []int, arr2 []int) []int {
    tmp := make([]int, 1001)
    for i := 0; i < len(arr1); i++ {
        tmp[arr1[i]]++
    }
    j := 0
    for i := 0; i < len(arr2); i++ {
        for tmp[arr2[i]] > 0 {
            arr1[j] = arr2[i]
            tmp[arr2[i]]--
            j++
        }
    }
    for i := 0; i < len(tmp); i++ {
        for tmp[i] > 0 {
            arr1[j] = i
            tmp[i]--
            j++
        }
    }

    return arr1
}