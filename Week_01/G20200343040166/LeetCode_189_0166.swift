/*
 * @lc app=leetcode id=189 lang=swift
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    /// 暴力解法：
    /// * 实现移动一步的算法，然后重复n次
    /// 优化解法1：
    /// * 先对k取余数，得到实际需要移动的步数
    /// * 重复上述步骤
    func brutalRotate(_ nums: inout [Int], _ k: Int) {
        var offset = k
        if (nums.count == 0 || nums.count == 1) {
            return
        }
        offset = offset % nums.count
        while ( offset > 0 ) {
            rotateOneStep(&nums)
            offset -= 1
        }
    }

    func rotateOneStep(_ nums: inout [Int]) {
        var lastIndex = nums.count - 1
        let lastValue = nums[lastIndex]
        while (lastIndex >= 0) {
            if (lastIndex == 0) {
                nums[lastIndex] = lastValue
            } else {
                nums[lastIndex] = nums[lastIndex - 1]
            }
            lastIndex -= 1
        }
    }
    /// 优化解法2：
    /// 3重翻转
    func brutalRotate(_ nums: inout [Int], _ k: Int) {
        let count = nums.count 
        if (count == 0 || count == 1) {
            return 
        }
        let offset = k % count
    }
}
// @lc code=end

