/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
  if (k==0) return [];
  const result = [];
  const dfs = (number, curr) => {
    if(curr.length === k) {
      result.push([...curr]);
      return
    };
    for (let i=number; i<=n; i++) {
      curr.push(i);
      dfs(i+1, curr);
      curr.pop();
    }
    
  }
  dfs(1, [])
  return result;
};

