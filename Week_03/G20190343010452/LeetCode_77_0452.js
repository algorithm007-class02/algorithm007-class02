/*
 * @lc app=leetcode.cn id=77 lang=javascript
 *
 * [77] 组合
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
  const result = [];
  const param = [];

  recur(1, param);
  return result;

  function recur(level, param) {
    if (param.length === k) {
      result.push(param.slice(0));
      return;
    }
    
    for(let i = level; i <= n; i++) {
      param.push(i);
      recur(i + 1, param);
      param.pop();
    }
  }
};
// @lc code=end

