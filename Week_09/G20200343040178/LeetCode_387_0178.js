/*
 * @Author: mingxing.huang
 * @Date: 2020-05-16 15:41:16
 */
/**
 * 387. 字符串中的第一个唯一字符
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function (s) {
    let map = {};
    for (let c of s) {
        map[c] === undefined ? map[c] = 1 : map[c]++;
    }
    for (let key in map) {
        if (map[key] === 1) {
            return s.indexOf(key);
        }
    }
    return -1;
};