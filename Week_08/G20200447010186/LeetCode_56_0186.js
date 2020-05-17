/**
 * 合并区间
 */

// 排序法
var merge = function (intervals) {
  if (!intervals.length) return [];
  const res = [];
  // 首先将数组中的每个区间按照左边界排序
  intervals.sort(function (a, b) {
    return a[0] - b[0];
  });
  // 然后将排好序的第一个区间放入结果数组
  res.push(intervals[0]);
  // 遍历之后的区间，每次和第一个区间比较
  for (var i = 1; i < intervals.length; i++) {
    // 如果当前比较的区间左边界比结果数组里最后一个区间的右边界大，说明不会重合，直接添加即可。
    if (intervals[i][0] > res[res.length - 1][1]) res.push(intervals[i]);
    // 重合情况：
    // 应该从【当前比较的区间】的右边界和【结果数组里最后一个区间】的右边界中取较大值，更新为【结果数组里最后一个区间】的新右边界
    if (intervals[i][1] > res[res.length - 1][1])
      res[res.length - 1][1] = intervals[i][1];
  }
  return res;
};
