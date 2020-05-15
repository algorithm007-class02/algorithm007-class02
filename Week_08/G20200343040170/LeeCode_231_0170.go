func isPowerOfTwo(n int) bool {
    if n == 0 {
        return false
    }
    return n & (-n) == n
}