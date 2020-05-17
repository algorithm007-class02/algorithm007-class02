/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
  if (!intervals.length) return [];
  intervals = intervals.sort((x, y) => parseInt(x[0]) - parseInt(y[0]));
  let result = [[intervals[0][0], intervals[0][0]]];
  intervals.forEach(item => {
      if (item[0] <= result[result.length - 1][1]) {
          result[result.length - 1][1] = Math.max(item[1], result[result.length - 1][1]);
      } else {
          result.push(item);
      }
  })
  return result;
};