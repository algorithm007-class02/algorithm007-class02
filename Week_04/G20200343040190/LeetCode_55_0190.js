var canJump = function(nums) {
  var lastPos = nums.length - 1;
  for (var i = nums.length - 1; i >= 0; i--) {
      if (i + nums[i] >= lastPos) {
          lastPos = i;
      }
  }
  return lastPos == 0;
};