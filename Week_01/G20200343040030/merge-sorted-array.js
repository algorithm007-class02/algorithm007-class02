/**
 * 暴力解
 * 时间复杂度 O((m+n)log(m+n)) ?? 空间复杂度O(1)
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  for (let i = 0; i < nums2.length; i++) {
    nums1[m + i] = nums2[i];
  }
  nums1 = nums1.sort((a, b) => a - b);
};
