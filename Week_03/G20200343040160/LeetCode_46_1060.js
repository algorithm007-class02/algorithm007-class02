/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
  //递归函数：传入剩余数字的数组，和剩余数字个数
      function fun(ans, perm, list, k) {
          //终止条件：k大于0
          if (k === 0) {
              //将当前排列传入答案数组
              ans.push(perm)
              return
          }
          //处理当前逻辑：将当前问题分治为k个k-1个数的排列
          list.forEach(item => {
              //下一层：把item插入当前排列，从list中去除item，个数k-1，传入递归函数
              fun(ans, perm.concat(item), list.filter(value => value !== item), k -1);
          })
      }
      let ans = [], perm = [];
      fun(ans, perm, nums, nums.length)
      return ans;
  };