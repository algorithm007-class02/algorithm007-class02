// LeetCode 91 解码方法
class Solution {
    func numDecodings(_ s: String) -> Int {
        let str = Array(s)
        let len = str.count
        if len < 1 {
            return 0
        }
        if len == 1 {
            return str[0] == "0" ? 0 : 1
        }
        var dp = Array(repeating: 0, count: len + 1)
        dp[0] = 1
        dp[1] = str[0] == "0" ? 0 : 1
        for i in 2 ..< len + 1 {
            var last = Int("\(str[i - 1])")!
            if last > 0 {
                dp[i] += dp[i - 1]
            }
            last = Int("\(str[i - 2])\(str[i - 1])")!
            
            if last >= 10 && last <= 26 {
                dp[i] += dp[i - 2]
            }
        }
        return dp[len]
    }
}