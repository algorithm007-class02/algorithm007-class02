/**
 * 时间复杂度 O(n) 空间复杂度O(n)
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  if (s.length !== t.length) {
    return false;
  }
  let map = {};

  for (let i = 0; i < s.length; i++) {
    map[s[i]] = (map[s[i]] || 0) + 1;
    map[t[i]] = (map[t[i]] || 0) - 1;
  }

  for (const key in map) {
    if (map[key] != 0) return false;
  }

  return true;
};

/**
 * 时间复杂度 O(nlogn)
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  if (s.length !== t.length) {
    return false;
  }
  return (
    s
      .split("")
      .sort()
      .join() ===
    t
      .split("")
      .sort()
      .join()
  );
};
