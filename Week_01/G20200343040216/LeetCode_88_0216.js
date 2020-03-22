/*
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。 
 */

var merge = function(nums1, m, nums2, n) {
  nums1.splice(m,n,...nums2);
  return nums1.sort((a,b) => a - b)
};
