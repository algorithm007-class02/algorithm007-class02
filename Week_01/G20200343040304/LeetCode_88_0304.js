/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function (nums1, m, nums2, n) {
  let arr = [];
  let i = 0;
  let j = 0;
  while (i < m && j < n) {
    if (nums1[i] <= nums2[j]) {
      arr.push(nums1[i]);
      i++;
    } else {
      arr.push(nums2[j]);
      j++
    }
  }

  if (i < m) {
    arr.push(...nums1.slice(i, m));
  } else {
    arr.push(...nums2.slice(j));
  }

  for (let i = 0; i < arr.length; i++) {
    nums1[i] = arr[i];
  }
};