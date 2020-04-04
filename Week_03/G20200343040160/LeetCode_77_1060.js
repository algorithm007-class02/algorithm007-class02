/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
  function fun(curr, comb) {
      if (comb.length === k) {
          ans.push(comb.concat())
      }
      for (let i = curr; i < n+1; i++) {
          comb.push(i)
          fun(i+1, comb);
          comb.pop();
      }
  }
  let ans = [], comb = [];
  fun(1, comb)
  return ans;
};