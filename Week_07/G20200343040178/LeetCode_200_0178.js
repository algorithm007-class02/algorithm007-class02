/*
 * @Author: mingxing.huang
 * @Date: 2020-04-23 22:03:00
 */
/**
 * 岛屿数量
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
    // // dfs
    // let row = grid.length;
    // if (row === 0) return [];
    // let dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    // let col = grid[0].length;
    // let res = 0;
    // for (let i = 0; i < row; i++) {
    //     for (let j = 0; j < col; j++) {
    //         if (grid[i][j] === '1') {
    //             res++;
    //             dfs(i, j);
    //         }
    //     }
    // }
    // return res;

    // function dfs(i, j) {
    //     if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] === '0') return;
    //     grid[i][j] = '0';
    //     for (let dir of dirs) {
    //         dfs(i + dir[0], j + dir[1]);
    //     }
    // }

    // bfs
    let row = grid.length;
    if (row === 0) return [];
    let col = grid[0].length;
    let dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    let res = 0;
    let q = [];
    for (let i = 0; i < row; i++) {
        for (let j = 0; j < col; j++) {
            if (grid[i][j] === '1') {
                res++;
                grid[i][j] = '0';
                q.push([i, j]);
                while (q.length > 0) {
                    let node = q.shift();
                    let x = node[0];
                    let y = node[1];
                    for (let dir of dirs) {
                        let nextX = x + dir[0];
                        let nextY = y + dir[1];
                        if (nextX >= 0 && nextX < row &&
                            nextY >= 0 && nextY < col &&
                            grid[nextX][nextY] === '0') {
                            q.push([nextX, nextY])
                            grid[nextX][nextY] = '0';
                        }
                    }
                }
            }
        }
    }
    return res;
}