func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }
    
    var count [26]int
    for _,c := range s {
        count[c - 'a']++
    }
    for _,c := range t {
        count[c - 'a']--
        if count[c - 'a'] < 0 {
            return false
        }
    }
    return true
}
