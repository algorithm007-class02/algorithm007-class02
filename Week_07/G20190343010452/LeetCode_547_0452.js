/**
 * @param {number[][]} M
 * @return {number}
 */

// DFS
var findCircleNum = function(M) {
  const visited = new Set();
  let res = 0;

  const dfs = (i) => {
    for (let j = 0; j < M[0].length; j++) {
      if (M[i][j] === 1 && !visited.has(j)) {
        visited.add(j);
        dfs(j);
      }
    }
  }

  for(let i = 0; i < M.length; i++) {
    if (!visited.has(i)) {
      dfs(i);
      res++;
    }
  }

  return res;
};
