/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
  const length = s.length;
  let dic = new Map();
  for (let i = 0; i < length; i++) {
      dic.set(s[i], 1 + (dic.get(s[i]) || 0));
  }

  for (let i = 0; i < length; i++) {
      if (dic.get(s[i]) === 1) return i;
  }

  return -1;
};