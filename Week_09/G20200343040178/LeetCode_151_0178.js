/*
 * @Author: mingxing.huang
 * @Date: 2020-05-16 16:09:18
 */
/**
 * 151. 翻转字符串里的单词
 * @param {string} s
 * @return {string}
 */
var reverseWords = function (s) {
    // 分割，过滤，翻转，连接
    return s.split(' ').filter(Boolean).reverse().join(' ');
};