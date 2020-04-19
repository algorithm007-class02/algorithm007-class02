func plusOne(digits []int) []int {
    var i, v int
    for i =len(digits)-1; i>=0; i-- {
        v = digits[i] + 1
        if v < 10 {
            digits[i] = v
            break
        }
        digits[i] = 0
    }
    if i == -1 && digits[0] == 0 {
        // 要进一位
        digits = append(digits, 0)
        digits[0] = 1
        for i = 1; i < len(digits); i++ {
            digits[i] = 0
        }
    }

    return digits
}
