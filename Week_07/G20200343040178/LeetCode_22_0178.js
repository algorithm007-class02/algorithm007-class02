/*
 * @Author: mingxing.huang
 * @Date: 2020-04-23 22:51:44
 */
/**
 * 括号生成
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
    // // dfs
    // let res = [];
    // dfs(0, 0, '');
    // return res;

    // function dfs(leftCnt, rightCnt, str) {
    //     if (leftCnt + rightCnt === 2 * n) {
    //         res.push(str);
    //         return;
    //     }
    //     if (leftCnt < n) {
    //         gen(leftCnt + 1, rightCnt, str + '(');
    //     }
    //     if (leftCnt > rightCnt) {
    //         gen(leftCnt, rightCnt + 1, str + ')');
    //     }
    // }

    // bfs
    let res = [];
    let q = [{ leftCnt: 0, rightCnt: 0, str: '' }];
    while (q.length > 0) {
        const { leftCnt, rightCnt, str } = q.shift();
        if (leftCnt + rightCnt === 2 * n) {
            res.push(str);
        }
        if (leftCnt < n) {
            q.push({ leftCnt: leftCnt + 1, rightCnt, str: str + '(' });
        }
        if (leftCnt > rightCnt) {
            q.push({ leftCnt, rightCnt: rightCnt + 1, str: str + ')' });
        }
    }
    return res;
}