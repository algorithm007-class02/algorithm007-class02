/**
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 */
var updateBoard = function(board, click) {
  if (board[click[0]][click[1]] == "M") {
    board[click[0]][click[1]] = "X";
    return board;
  }
  let m = board.length;
  let n = board[0].length;
  let dx = [1, 1, 1, -1, -1, -1, 0, 0];
  let dy = [-1, 0, 1, -1, 0, 1, -1, 1];
  let queue = [click];
  let visited = {};
  visited[click[0] + "-" + click[1]] = true;
  let getNumsBombs = (board, x, y) => {
    let count = 0;
    for (let i = 0; i < 8; i++) {
      let newX = x + dx[i];
      let newY = y + dy[i];
      if (newX == x && newY == y) {
        continue;
      }
      if (
        newX >= 0 &&
        newX < board.length &&
        newY < board[0].length &&
        newY >= 0
      ) {
        if (board[newX][newY] == "M" || board[newX][newY] == "X") {
          count++;
        }
      }
    }
    return count;
  };
  while (queue.length != 0) {
    let cell = queue.shift();
    let x = cell[0];
    let y = cell[1];
    let num = getNumsBombs(board, x, y);
    if (num == 0) {
      board[x][y] = "B";
      for (let i = 0; i < 8; i++) {
        let newX = x + dx[i];
        let newY = y + dy[i];
        if (
          !visited[newX + "-" + newY] &&
          newX >= 0 &&
          newX < board.length &&
          newY >= 0 &&
          newY < board[0].length &&
          board[newX][newY] == "E"
        ) {
          queue.push([newX, newY]);
          visited[newX + "-" + newY] = true;
        }
      }
    } else {
      board[x][y] = num + "";
    }
  }
  return board;
};
