/*
 * @Author: mingxing.huang
 * @Date: 2020-05-16 16:07:36
 */
/**
 * 541. 反转字符串 II
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reverseStr = function (s, k) {
    let res = '';
    for (let i = 0; i < s.length; i += 2 * k) {
        let sub = s.substring(i, Math.min(i + 2 * k, s.length))
        res += helper(sub);
    }
    return res;

    function helper(str) {
        let len = str.length;
        if (len === 1) {
            return str;
        }
        if (len >= k) {
            let front = str.substring(0, k);
            let end = str.substring(k);
            return front.split('').reverse().join('') + end;
        }
        return str.split('').reverse().join('');
    }
};