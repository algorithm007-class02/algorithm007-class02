/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {

  var left = 0; 
  var right = nums.length - 1;
  
  while (left <= right) {
      var mid = Math.floor((right + left ) / 2 );

      if (nums[mid] === target) return mid;

          if (nums[left] <= nums[mid]) {
              //target在前半部分
              if (target >= nums[left] && target < nums[mid]) {
                  right = mid - 1;
              } else {
                  left = mid + 1;
              }
          } else {
              if (target <= nums[right] && target > nums[mid]) {
                  left = mid + 1;
              } else {
                  right = mid - 1;
              }
          }

  }

  return -1;

};