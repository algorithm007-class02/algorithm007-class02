/*
 * @Author: mingxing.huang
 * @Date: 2020-04-03 10:59:46
 */
/**
 * 455. 分发饼干
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
  let res = 0;
  g.sort((a, b) => a - b);
  s.sort((a, b) => a - b);
  let i = 0; // 孩子
  let j = 0; // 饼干
  while (i < g.length && j < s.length) {
    if (s[j] >= g[i]) {
      res++;
      i++;
      j++;
    } else {
      // 不能满足，换一块大的
      j++;
    }
  }
  return res;
};
