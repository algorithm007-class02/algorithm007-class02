/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function (n, k) {

  var results = [];
  var could = [];
  if (k == 0) {
    return [[]]
  }
  function dfs(start, n, k, results, could) {
    if (could.length == k) {
      results.push(could.slice(0));
      return;
    }
    for (var i = start; i < n + 1; i++) {
      could.push(i);
      dfs(i + 1, n, k, results, could);
      could.pop()
    }
    return results;
  }
  return dfs(1, n, k, results, could)
};