/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
  g.sort((a, b) => a - b);
  s.sort((a, b) => a - b);

  var cookie = 0;
  var child = 0;

  while(child < g.length && cookie < s.length) {
      if (s[cookie] >= g[child]) child++;
      cookie++
  }

  return child

};