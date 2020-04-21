/**
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
  const len = s.length;
  let max = [0];
  if (s[0] === '(' && s[1] === ')') {
      max.push(2);
  } else {
      max.push(0)
  }
  for (let i = 2; i < len; i++) {
      if (s[i] === ')') {
          if (s[i - 1] === '(') {
              max.push(max[i - 2] + 2);
          } else {
              if (s[i - max[i - 1] - 1] === '(') {
                  max.push(max[i - 1] + (max[i - max[i - 1] - 2] || 0) + 2);
              } else {
                  max.push(0);
              }
          }
      } else {
          max.push(0);
      }
  }
  return Math.max(...max);
};