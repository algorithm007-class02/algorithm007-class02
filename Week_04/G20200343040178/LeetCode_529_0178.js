/*
 * @Author: mingxing.huang
 * @Date: 2020-04-02 22:28:39
 */
/**
 * 529. 扫雷游戏
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 */
var updateBoard = function(board, click) {
  // 八个方向
  const dirs = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
    [-1, 1],
    [-1, -1],
    [1, 1],
    [1, -1]
  ];
  const row = click[0];
  const col = click[1];
  if (board[row][col] === "M" || board[row][col] === "X") {
    board[row][col] = "X";
    return board;
  }
  // 寻找周围的雷
  let num = count(row, col);
  if (num > 0) {
    // 如果该位置周围有雷，就返回
    board[row][col] = num + "";
    return board;
  }
  board[row][col] = "B";
  // 从八个方向非雷空方块继续寻找
  for (let dir of dirs) {
    const newRow = row + dir[0];
    const newCol = col + dir[1];
    if (
      newRow >= 0 &&
      newRow < board.length &&
      newCol >= 0 &&
      newCol < board[0].length &&
      board[newRow][newCol] === "E"
    ) {
      updateBoard(board, [newRow, newCol]);
    }
  }
  return board;

  function count(row, col) {
    let num = 0;
    for (let dir of dirs) {
      const newRow = row + dir[0];
      const newCol = col + dir[1];
      if (
        newRow >= 0 &&
        newRow < board.length &&
        newCol >= 0 &&
        newCol < board[0].length &&
        board[newRow][newCol] === "M"
      ) {
        num++;
      }
    }
    return num;
  }
};
