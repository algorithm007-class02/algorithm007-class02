/*
 * @Author: mingxing.huang
 * @Date: 2020-03-20 14:58:42
 */
/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
   输入: s = "anagram", t = "nagaram"
   输出: true
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  //   // 方法一：将两个字符串排序，比较是否相等
  //   return (
  //     Array.from(s)
  //       .sort()
  //       .join("") ===
  //     Array.from(t)
  //       .sort()
  //       .join("")
  //   );

  // 方法二：通过字符出现的个数是否相等，来判断
  if (s.length !== t.length) return false;
  if (s === t) return true;
  let hashMap = {};
  for (let i = 0; i < s.length; i++) {
    // s增加当前字符，t减少当前字符，若最终值0，即异位
    if (hashMap[s[i]] !== undefined) {
      hashMap[s[i]]++;
    } else {
      hashMap[s[i]] = 1;
    }
    if (hashMap[t[i]] !== undefined) {
      hashMap[t[i]]--;
    } else {
      hashMap[t[i]] = -1;
    }
  }
  for (const val of Object.values(hashMap)) {
    if (val !== 0) {
      return false;
    }
  }
  return true;
};
