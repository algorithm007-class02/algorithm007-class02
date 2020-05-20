func isIsomorphic(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }

    for i := 0; i < len(s); i++ {
        if strings.IndexByte(s, s[i]) != strings.IndexByte(t, t[i]) {
            return false
        }
    }

    return true
}