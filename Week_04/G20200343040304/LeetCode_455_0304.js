/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function (g, s) {
  let sum = 0;
  let i = 0;
  let j = 0;
  g.sort((a, b) => a - b);
  s.sort((a, b) => a - b);
  console.log(g, s)
  while (i < g.length && j < s.length) {
    if (g[i] <= s[j]) {
      sum += 1;
      i++;
      j++
    } else {
      j++
    }
  }
  return sum;
};