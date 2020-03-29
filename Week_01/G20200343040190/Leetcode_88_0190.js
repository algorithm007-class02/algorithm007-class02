/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  var index1 = m - 1;
  var index2 = n - 1;
  var index = m + n -1;

  if (m > 0) {
    while(index >= 0)
      if (index1 >=0 && index2 >= 0) {
        if (nums1[index1] < nums2[index2]) {
          nums1[index--] = nums2[index2--];
        } else {
          nums1[index--] = nums1[index1--]; 
        }
      } else if (index1 < 0 && index2 >= 0) {
        nums1[index--] = nums2[index2--];
      } else if (index2 < 0 && index1 >= 0) {
        nums1[index--] = nums1[index1--];
      }       
  } else {
    while(index2 >=0 && index >= 0 )
      nums1[index--] = nums2[index2--];
  }  

  console.log(nums1);
};

// merge([4,0,0,0,0,0],1,[1,2,3,5,6],5);
// merge([2,0],1,[1], 1);
// merge([0],0,[1], 1);
// merge([1,2,3,0,0,0], 3, [2,5,6], 3);
merge([4,5,6,0,0,0], 3, [1,2,3], 3);