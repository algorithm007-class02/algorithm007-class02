/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  s = s.split('').sort().join('');
  t = t.split('').sort().join('');
  return s === t;
};