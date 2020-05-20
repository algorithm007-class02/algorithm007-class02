func reverseWords(s string) string {
    s2 := strings.Split(s, " ")
    sn := make([]string, 0, len(s2))
    for i := len(s2) - 1; i >= 0; i-- {
        s2[i] = strings.TrimSpace(s2[i])
        if s2[i] != "" {
            sn = append(sn, s2[i])
        }
    }
    return strings.Join(sn, " ")
}