/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  var map = {};
  var result = [];
  for (var i = 0; i<nums.length; i++) {    
    var complement = target - nums[i];   
    if (map[nums[i]] >= 0) {
      result = [map[nums[i]], i];
      break;
    }
    map[complement] = i;
  }
  return result;
};

// var res = twoSum([2,7,11,15], 9);
// console.log(res);
/**
 * 
 * var twoSum = function(nums, target) {
  var result = [];
  for (var i = 0; i<nums.length; i++) {
    var index = nums.indexOf(target - nums[i]);
    if ( index> -1 && i !== index) {
      result = [i, index];
      break;
    }
  }  
  console.log(result);
  return result;
};
 */
/*
var twoSum = function(nums, target) {
  var index = nums.length-1;
  var result = [];
  while(index >= 0) {
    for(var i = 0; i < index; i++) {
      if (nums[i] === target - nums[index]) {
        result = [i, index];
        break;
      }      
    }
    index--;
  }  
  console.log('result ==> ', result);
  return result;
};
*/