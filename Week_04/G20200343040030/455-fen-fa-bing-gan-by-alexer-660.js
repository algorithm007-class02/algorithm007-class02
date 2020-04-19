/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
  g = g.sort((a, b) => a - b);
  s = s.sort((a, b) => a - b);
  var gLen = g.length;
  var sLen = s.length;
  var i = 0;
  var j = 0;
  var maxNum = 0;
  while (i < gLen && j < sLen) {
    if (s[j] >= g[i]) {
      i++;
      j++;
      maxNum++;
    } else {
      j++;
    }
  }
  return maxNum;
};
