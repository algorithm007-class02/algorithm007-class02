/*
 * @lc app=leetcode.cn id=493 lang=cpp
 *
 * [493] 翻转对
 */

// @lc code=start
class Solution {
public:
    int reversePairs(vector<int> &nums) {
        if (nums.size() == 0)
            return 0;
        return mergeSort(nums, 0, nums.size() - 1);
    }

// 标准归并排序，归并时处理翻转对
private:
    int mergeSort(vector<int> &nums, int l, int r) {
        if (l >= r)
            return 0;
        int mid = l + (r - l) / 2;
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
        vector<int> cache(r - l + 1);
        int i = l, t = l, c = 0;
        for (int j = mid + 1; j <= r; ++j, ++c) {
            while (i <= mid && nums[i] / 2.0 <= nums[j])
                i++;
            while (t <= mid && nums[t] < nums[j])
                cache[c++] = nums[t++];
            cache[c] = nums[j];
            count += mid - i + 1;
        }
        while (t <= mid)
            cache[c++] = nums[t++];
        for (int k = 0; k < r - l + 1; ++k) {
            nums[l + k] = cache[k];
        }
        return count;
    }
};
// @lc code=end
