/*
 * @Author: mingxing.huang
 * @Date: 2020-04-24 11:22:29
 */
/**
 * 被围绕的区域
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solve = function (board) {
    // 从四条边开始寻找O，把和边界O联通的O，标记成@，再将其他的O标记成X，最后将@变回O
    let row = board.length;
    if (row === 0) return [];
    let col = board[0].length;
    let dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    for (let i = 0; i < row; i++) {
        if (i === 0 || i === row - 1) {
            for (let j = 0; j < col; j++) {
                if (board[i][j] === 'O') {
                    dfs(i, j);
                }
            }
        } else {
            for (let j of [0, col - 1]) {
                if (board[i][j] === 'O') {
                    dfs(i, j);
                }
            }
        }
    }
    for (let i = 0; i < row; i++) {
        for (let j = 0; j < col; j++) {
            if (board[i][j] === 'O') {
                board[i][j] = 'X'
            }
        }
    }
    for (let i = 0; i < row; i++) {
        for (let j = 0; j < col; j++) {
            if (board[i][j] === '@') {
                board[i][j] = 'O'
            }
        }
    }

    function dfs(i, j) {
        if (i >= 0 && i < row && j >= 0 && j < col && board[i][j] === 'O') {
            board[i][j] = '@';
            for (let dir of dirs) {
                dfs(i + dir[0], j + dir[1]);
            }
        }
    }
};