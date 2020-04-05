func maxProfit(prices []int) int {
    profit := 0
    tmp := 0
    for i := 1; i < len(prices); i++ {
        if tmp = prices[i] - prices[i-1]; tmp > 0 {
            profit += tmp
        }
    }

    return profit
}