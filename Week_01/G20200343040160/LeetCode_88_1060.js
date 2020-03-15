/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  let j = 0;
  for (let i = 0; i  < n; i++) {
    for (;j < m; j++) {
      //找到相应位置，将nums2元素插入到nums1
      if (nums2[i] < nums1[j]) {
        for (let k = m; k > j; k--) {
          nums1[k] = nums1[k-1];
        }
        break;
      }
    }
    nums1[j++] = nums2[i];
    m++
  }
};