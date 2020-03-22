/*
 * @lc app=leetcode id=88 lang=swift
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    /// 思路:
    /// 使用双指针，进行合并，从后向前
    func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
        var nums1Index = m - 1
        var num2Index = n - 1
        var targetIndex = m + n - 1
        while ( nums1Index >= 0 && num2Index >= 0 ) {
            if (nums1[nums1Index] > nums2[num2Index]) {
                nums1[targetIndex] = nums1[nums1Index]
                targetIndex -= 1
                nums1Index -=1
            } else {
                nums1[targetIndex] = nums2[num2Index]
                targetIndex -= 1
                num2Index -= 1
            }
        }
        while (num2Index >= 0) {
            nums1[targetIndex] = nums2[num2Index]
            targetIndex -= 1
            num2Index -= 1
        }
    }
}
// @lc code=end

