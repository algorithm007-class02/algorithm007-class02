/*
 * @lc app=leetcode id=26 lang=swift
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    func removeDuplicates(_ nums: inout [Int]) -> Int {
        if nums.count == 0 {
            return 0
        }
        var previous = 0
        var back = 1
        while back < nums.count {
            if (nums[previous] != nums[back]) {
                nums[previous + 1] = nums[back]
                previous += 1
            }
            back += 1
        }
        return previous + 1
    }

    // func removeUnorderedDuplicates(_ nums: inout [Int]) -> Int {
    //     var count = nums.count
    //     var maxLength = nums.count
    //     if ( count == 0 ) {
    //         return maxLength
    //     }
    //     for outIndex in 0..< count-1 {
    //         let out = nums[outIndex]
    //         for innerIndex in outIndex+1 ..< count {
    //             let inner = nums[innerIndex]
    //             if (inner == out) {
    //                 if (inner + 1 < count) {
    //                     nums[innerIndex] = nums[innerIndex + 1]
    //                 }
    //                 maxLength -= 1
    //             }
    //         }
    //     }
    //     return maxLength
    // }
}
// @lc code=end

