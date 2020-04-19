/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
  function fun(ans, perm, list, k) {
      //终止条件：k大于0
      if (k === 0) {
          //将当前排列传入答案数组
          ans.push(perm)
          return
      }
      //处理当前逻辑：将当前问题分治为去重后的值的个数k-1个数的排列
      let setOfList = new Set(list);
      setOfList.forEach(item => {
          let index = list.findIndex(value => value === item);
          //下一层：把item插入当前排列，从list中去除第一个item，个数k-1，传入递归函数
          fun(ans, perm.concat(item), list.filter((v, i) => i !== index), k -1);
      })
  }
  let ans = [], perm = [];
  fun(ans, perm, nums, nums.length)
  return ans;
};