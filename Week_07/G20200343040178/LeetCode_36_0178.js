/*
 * @Author: mingxing.huang
 * @Date: 2020-04-24 11:24:42
 */
/**
 * 有效的数独
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function (board) {
    // // 迭代3次，分别校验行、列、块
    // for (let i = 0; i < board.length; i++) {
    //     for (let j = 0; j < board.length; j++) {
    //         const cur = board[i][j];
    //         if (cur !== '.') {
    //             if (!rowNums(i, j, cur) || !colNums(i, j, cur) || !blockNums(i, j, cur)) {
    //                 return false;
    //             }
    //         }
    //     }
    // }
    // return true;
    // // 校验行
    // function rowNums(row, col, cur) {
    //     for (let j = 0; j < board.length; j++) {
    //         if (j !== col && board[row][j] === cur) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // // 校验列
    // function colNums(row, col, cur) {
    //     for (let i = 0; i < board.length; i++) {
    //         if (i !== row && board[i][col] === cur) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // // 校验块
    // function blockNums(row, col, cur) {
    //     if (row >= 0 && row <= 2) {
    //         if (col >= 0 && col <= 2) {
    //             for (let i = 0; i <= 2; i++) {
    //                 for (let j = 0; j <= 2; j++) {
    //                     if (i !== row && j !== col && board[i][j] === cur) {
    //                         return false;
    //                     }
    //                 }
    //             }
    //         } else if (col > 2 && col <= 5) {
    //             for (let i = 0; i <= 2; i++) {
    //                 for (let j = 3; j <= 5; j++) {
    //                     if (i !== row && j !== col && board[i][j] === cur) {
    //                         return false;
    //                     }
    //                 }
    //             }
    //         } else {
    //             for (let i = 0; i <= 2; i++) {
    //                 for (let j = 6; j <= 9; j++) {
    //                     if (i !== row && j !== col && board[i][j] === cur) {
    //                         return false;
    //                     }
    //                 }
    //             }
    //         }
    //     } else if (row > 2 && row <= 5) {
    //         if (col >= 0 && col <= 2) {
    //             for (let i = 3; i <= 5; i++) {
    //                 for (let j = 0; j <= 2; j++) {
    //                     if (i !== row && j !== col && board[i][j] === cur) {
    //                         return false;
    //                     }
    //                 }
    //             }
    //         } else if (col > 2 && col <= 5) {
    //             for (let i = 3; i <= 5; i++) {
    //                 for (let j = 3; j <= 5; j++) {
    //                     if (i !== row && j !== col && board[i][j] === cur) {
    //                         return false;
    //                     }
    //                 }
    //             }
    //         } else {
    //             for (let i = 3; i <= 5; i++) {
    //                 for (let j = 6; j <= 9; j++) {
    //                     if (i !== row && j !== col && board[i][j] === cur) {
    //                         return false;
    //                     }
    //                 }
    //             }
    //         }
    //     } else if (row > 5 && row <= 9) {
    //         if (col >= 0 && col <= 2) {
    //             for (let i = 6; i < 9; i++) {
    //                 for (let j = 0; j <= 2; j++) {
    //                     if (i !== row && j !== col && board[i][j] === cur) {
    //                         return false;
    //                     }
    //                 }
    //             }
    //         } else if (col > 2 && col <= 5) {
    //             for (let i = 6; i < 9; i++) {
    //                 for (let j = 3; j <= 5; j++) {
    //                     if (i !== row && j !== col && board[i][j] === cur) {
    //                         return false;
    //                     }
    //                 }
    //             }
    //         } else {
    //             for (let i = 6; i < 9; i++) {
    //                 for (let j = 6; j < 9; j++) {
    //                     if (i !== row && j !== col && board[i][j] === cur) {
    //                         return false;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }

    // 迭代一次
    // 9行、9列、9个块，每个包含一个计数的字典，如果有数字的个数超过1，即数组无效
    let rows = Array.from(Array(9), () => new Map());
    let cols = Array.from(Array(9), () => new Map());
    let blocks = Array.from(Array(9), () => new Map());
    for (let i = 0; i < 9; i++) {
        for (let j = 0; j < 9; j++) {
            let num = board[i][j];
            if (num !== '.') {
                num = parseInt(num);
                let blockIndex = parseInt(i / 3) * 3 + parseInt(j / 3);
                if (rows[i][num] === undefined) {
                    rows[i][num] = 1;
                } else {
                    return false;
                }
                if (cols[j][num] === undefined) {
                    cols[j][num] = 1;
                } else {
                    return false;
                }
                if (blocks[blockIndex][num] === undefined) {
                    blocks[blockIndex][num] = 1;
                } else {
                    return false;
                }
            }
        }
    }
    return true;
};