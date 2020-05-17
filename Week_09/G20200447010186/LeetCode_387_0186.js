/**
 * 字符串中的第一个唯一字符:
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
/**
 * @param {string} s
 * @return {number}
 */

/**
 *  解法一：map映射法
 */

var firstUniqChar = function (s) {
  let map = {};

  for (let char of s) {
    map[char] ? map[char]++ : (map[char] = 1);
  }

  for (let i = 0; i < s.length; i++) {
    if (map[s[i]] === 1) return i;
  }

  return -1;
};

/**
 * 解法2
 */
var firstUniqChar = function (s) {
  for (i = 0; i < s.length; i++)
    if (s.indexOf(s[i]) === s.lastIndexOf(s[i])) return i;
  return -1;
};
