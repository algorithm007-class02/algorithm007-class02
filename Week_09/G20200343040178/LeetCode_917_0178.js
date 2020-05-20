/*
 * @Author: mingxing.huang
 * @Date: 2020-05-16 16:30:11
 */
/**
 * 917. 仅仅反转字母
 * @param {string} S
 * @return {string}
 */
var reverseOnlyLetters = function (S) {
    // 保存非字母及其位置
    let map = {};
    // 保存字母
    let arr = [];
    for (let i = 0; i < S.length; i++) {
        if (/[a-zA-Z]/.test(S[i])) {
            arr.push(S[i])
        } else {
            map[i] = S[i];
        }
    }
    // 将字母翻转
    arr.reverse();
    // 将非字母插入
    for (let index in map) {
        arr.splice(index, 0, map[index]);
    }
    return arr.join('');
};