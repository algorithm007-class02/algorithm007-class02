func findContentChildren(g []int, s []int) int {
    sort.Ints(g)
    sort.Ints(s)
    var i, j int
    for i < len(g) && j < len(s) {
        if g[i] <= s[j] {
            i++
            j++
        } else {
            j++
        }
    }
    return i
}