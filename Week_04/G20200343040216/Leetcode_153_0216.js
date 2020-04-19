/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
  var left = 0; 
  var right = nums.length - 1;
  var min = nums[0];
  
  while (left <= right) {
      var mid = Math.floor((right + left ) / 2 );

     if (nums[mid] > nums[mid + 1]) {
        return nums[mid + 1];
      }

      if (nums[mid - 1] > nums[mid]) {
        return nums[mid];
      }
      if (nums[mid] > nums[0]) {
        left = mid + 1;
      } else {

        right = mid -1
      }

  }

  return min;
};