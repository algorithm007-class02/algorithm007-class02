// leetCode 64 最小路径和
class Solution {
func minPathSum(_ grid: [[Int]]) -> Int {
    guard !grid.isEmpty && !grid.first!.isEmpty else { return 0 }
    
    class Model {
        var value = 0
    }
    
    let dp = grid.map { $0.map { _ in Model() } }
    
    grid.enumerated().forEach { (element1) in
        element1.element.enumerated().forEach { (element2) in
            let offset1 = element1.offset
            let offset2 = element2.offset
            
            let value: Int
            switch (offset1, offset2) {
            case (0, 0):
                value = 0
            case (0, _):
                value = dp[offset1][offset2 - 1].value
            case (_, 0):
                value = dp[offset1 - 1][offset2].value
            default:
                value = min(dp[offset1][offset2 - 1].value, dp[offset1 - 1][offset2].value)
            }
            
            dp[offset1][offset2].value = value + element2.element
        }
    }
    return dp.last?.last?.value ?? 0
}
}