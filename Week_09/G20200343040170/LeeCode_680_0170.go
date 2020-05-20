func validPalindrome(s string) bool {
    low  := 0
    high := len(s) - 1
    for low < high {
        if s[low] != s[high] {
            // 删除左侧字符
            if validPalindromeNoDelete(s[low+1:high+1]) {
                return true
            }
            // 删除右侧字符
            if validPalindromeNoDelete(s[low:high]) {
                return true
            }
            return false
        }
        low++
        high--
    }
    return true
}

func validPalindromeNoDelete(s string) bool {
    low  := 0
    high := len(s) - 1
    for low < high {
        if s[low] != s[high] {
            return false
        }
        low++
        high--
    }
    return true
}