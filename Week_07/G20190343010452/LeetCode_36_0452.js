/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function (board) {
  for (let i = 0; i < 9; i++) {
    let row = new Set(),
      col = new Set(),
      box = new Set();

    for (let j = 0; j < 9; j++) {
      let row$ = board[i][j];
      let col$ = board[j][i];
      let box$ = board[3 * Math.floor(i / 3) + Math.floor(j / 3)][3 * (i % 3) + (j % 3)];

      if (row$ != '.') {
        if (row.has(row$)) return false;
        row.add(row$);
      }

      if (col$ != '.') {
        if (col.has(col$)) return false;
        col.add(col$);
      }

      if (box$ != '.') {
        if (box.has(box$)) return false;
        box.add(box$);
      }
    }
  }

  return true;
};