/*
 * @Author: mingxing.huang
 * @Date: 2020-05-16 15:43:19
 */
/**
 * 8. 字符串转换整数 (atoi)
 * @param {string} str
 * @return {number}
 */
var myAtoi = function (str) {
    let res = parseInt(str.trim().match(/^(-|\+)?\d+/g)) || 0;
    return Math.max(Math.min(res, 2 ** 31 - 1), (-2) ** 31);
};