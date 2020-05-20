/*
 * @Author: mingxing.huang
 * @Date: 2020-05-16 16:13:23
 */
/**
 * 557. 反转字符串中的单词 III
 * @param {string} s
 * @return {string}
 */
var reverseWords = function (s) {
    return s.split(' ').filter(Boolean).map(w => w.split('').reverse().join('')).join(' ');
};