/**
 * 题目：岛屿数量
 * @param {character[][]} grid
 * @return {number}
 */

/**
  * 测试用例数据结构
  * [ 
        [ '1', '1', '1', '1', '0' ],
        [ '1', '1', '0', '1', '0' ],
        [ '1', '1', '0', '0', '0' ],
        [ '0', '0', '0', '0', '0' ] 
    ]
  */

/**
 * 解法1: 深度优先搜索
 * 初始：岛屿数量count = 0
 * 思路：两重循环遍历数组，遇到元素为1的就将岛屿数量count+1，并且围绕这个点对周围相邻节点进行【沉没操作：即化1为0】
 */
var numIslands = function (grid) {
  // 初始化岛屿数量
  let count = 0;
  // row 容器数组的长度，即为总行数
  const r = grid.length;
  // 边界条件
  if (r === 0) return 0;

  //column 内部每个成员数组的长度，即横向宽度
  const c = grid[0].length;

  for (let i = 0; i < r; i++) {
    for (let j = 0; j < c; j++) {
      if (grid[i][j] === "1") {
        count += 1;
        dfsMarking(i, j); // 执行沉没过程
      }
    }
  }
  return count;

  // 功能函数
  function dfsMarking(i, j) {
    // terminator
    if (i < 0 || j < 0 || i >= r || j >= c || grid[i][j] !== "1") {
      return;
    }
    grid[i][j] === 0;
    dfsMarking(i - 1, j);
    dfsMarking(i + 1, j);
    dfsMarking(i, j - 1);
    dfsMarking(i, j + 1);
  }
};
