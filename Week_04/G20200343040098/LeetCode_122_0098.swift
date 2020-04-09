// 122. 买卖股票的最佳时机 II
class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        guard prices.count > 1 else {return 0}
        var maxP = 0
        for i in 1 ..< prices.count {
            var todayP = prices[i] - prices[i - 1]
            if todayP > 0 {
                maxP +=  todayP
            }
        }
        return maxP
    }
}