// 1.两数之和
// https://leetcode-cn.com/problems/two-sum/
class Solution {
    // 用hash map实现
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var map: [Int : Int] = [:]

        for i in 0..<nums.count {
            let currentNum = nums[i]
            let anotherNum = target - currentNum
            // 有目标数 则说明之前已经存储了,直接返回
            if let mIndex = map[anotherNum] {
                return [mIndex, i]
            } else {
                // 存储该数
                map[currentNum] = i
            }
        }
        return []
    }
}