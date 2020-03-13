/*
 * @Author: mingxing.huang
 * @Date: 2020-03-13 16:51:55
 */
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  // // 方法一：两行代码，用数组api，删除nums1后面的0，将nums2添加到nums1，排序
  // nums1.splice(m, nums1.length - m, ...nums2);
  // nums1.sort((a, b) => a - b);

  // 方法二：三指针，从后往前比较，
  let i = m + n - 1; // 排序数组的下标
  let j = m - 1; // nums1下标
  let k = n - 1; // nums2下标
  while (j >= 0 && k >= 0) {
    // 将较大的数赋值到nums1尾部
    nums1[i--] = nums1[j] < nums2[k] ? nums2[k--] : nums1[j--];
  }
  // nums1比较完了，将nums2剩下的复制给nums1
  for (let i = 0; i <= k; i++) {
    nums1[i] = nums2[i];
  }
};
