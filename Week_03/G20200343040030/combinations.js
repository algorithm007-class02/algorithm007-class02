/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
  let res = [];
  function backtrack(path, start) {
    if (path.length == k) return res.push([...path]);
    for (let i = start; i <= n; i++) {
      path.push(i);
      backtrack(path, i + 1);
      path.pop();
    }
  }
  backtrack([], 1);

  return res;
};
