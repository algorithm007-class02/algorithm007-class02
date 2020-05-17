/*
 * @lc app=leetcode.cn id=1095 lang=cpp
 *
 * [1095] 山脉数组中查找目标值
 */

// @lc code=start
/**
 * // This is the MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * class MountainArray {
 *   public:
 *     int get(int idx);
 *     int length();
 * };
 */

class Solution {
public:
    int findInMountainArray(int target, MountainArray &mountainArr) {
        int left = 0, right = mountainArr.length() - 1;
        // find the peak point
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int peak = left;
        int idx = division(mountainArr, target, 0, peak, 1);
        if (idx != -1) {
            return idx;
        }
        return division(mountainArr, target, peak + 1, mountainArr.length() - 1, -1);
    }

    int division(MountainArray &mountain, int target, int left, int right, int reverse) {
        //利用reverse实现全部正序二分查找
        target *= reverse;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cur = reverse * mountain.get(mid);
            if (cur == target) {
                return mid;
            } else if (cur < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
};
// @lc code=end
