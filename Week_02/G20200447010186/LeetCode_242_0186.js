/**
 * 题目：有效的字母异位词
 * 描述：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */

/**
 * 暴力法
 * 初始思路：先将2个字符串分割为数组，再各自排序，比较排序之后转换为的字符串 是否相等皆可
 * 优化点：若给定的字符串长度不相同，可直接返回false
 * 时间复杂度较高
 * */
var isAnagram = function(s, t) {
  // 优化，可提前返回
  if (s.length !== t.length) return false;
  //   const sortS = s
  //     .split("")
  //     .sort()
  //     .join("");
  //   const sortT = t
  //     .split("")
  //     .sort()
  //     .join("");
  //   return sortS === sortT;

  // 优化
  const sortS = s.split("");
  const sortT = t.split("");

  return sortS.sort().join("") === sortT.sort().join("");
};

/**
 * hash表法
 * 思路：储存字符串中每个字母的出现次数
 */

var isAnagram = function(s, t) {
  const map = new Map();
  for (let i = 0; i < s.length; i++) {
    const count = map.get(s[i]);
    if (!map.get(s[i])) {
      map.set(s[i], 1);
    } else {
      map.set(s[i], count + 1);
    }
  }

  for (let i = 0; i < t.length; i++) {
    const count = map.get(t[i]);
    // 直到减到1时可移除
    if (count === 1) {
      map.delete(t[i]);
    } else if (map.get(t[i])) {
      map.set(t[i], count - 1);
    } else {
      map.set(t[i], 1);
    }
  }

  if (map.size !== 0) {
    return false;
  } else {
    return true;
  }
};
