/**
 * 题目：朋友圈
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
 * 如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
 * 如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 */

/**
 * 解法1:DFS
 */
var findCircleNum = function (M) {
  const seen = new Set();
  let res = 0;
  const dfs = (i) => {
    for (let j = 0; j < M[0].length; j++) {
      if (M[i][j] === 1 && !seen.has(j)) {
        seen.add(j);
        dfs(j);
      }
    }
  };
  for (let i = 0; i < M.length; i++) {
    if (!seen.has(i)) {
      dfs(i);
      res++;
    }
  }

  return res;
};

/**
 *  解法2:并查集 + 路径压缩
 * @param {number[][]} M
 * @return {number}
 */

var findCircleNum = function (M) {
  let count = M.length,
    parent = [],
    rank = Array(M.length).fill(0);

  function find(i) {
    while (parent[i] !== undefined) i = parent[i];
    return i;
  }
  function union(i, j) {
    const rootI = find(i),
      rootJ = find(j);
    if (rootI === rootJ) return;
    if (rank[rootI] > rank[rootJ]) {
      parent[rootJ] = rootI;
      rank[rootI]++;
    } else {
      parent[rootI] = rootJ;
      rank[rootJ]++;
    }
    count--;
  }
  for (let i = 0; i < M.length; i++) {
    for (let j = 0; j <= i; j++) {
      if (M[i][j]) union(i, j);
    }
  }
  return count;
};
