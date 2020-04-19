func lemonadeChange(bills []int) bool {
    var five, ten int
    for _, bill := range bills {
        if bill == 5 {
            five++
            continue
        }
        if bill == 10 {
            if five > 0 {
                five--
                ten++
                continue
            }
            return false
        }
        // twenty
        if five > 0 && ten > 0 {
            five--
            ten--
            continue
        }
        if five >= 3 {
            five -= 3
            continue
        }
        return false
    }

    return true
}
