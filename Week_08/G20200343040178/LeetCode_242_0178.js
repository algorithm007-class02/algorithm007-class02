/*
 * @Author: mingxing.huang
 * @Date: 2020-05-06 21:43:40
 */
/**
 * 有效的字母异位词
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function (s, t) {
    // 思路：字母个数相同为异位词
    if (s.length !== t.length) return false;
    if (s === t) return true;
    let m = {};
    for (let i = 0; i < s.length; i++) {
        m[s[i]] === undefined ? m[s[i]] = 1 : m[s[i]]++;
        m[t[i]] === undefined ? m[t[i]] = -1 : m[t[i]]--;
    }
    return Object.values(m).every(v => v === 0);
}