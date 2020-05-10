/*
 * @Author: mingxing.huang
 * @Date: 2020-05-06 21:52:44
 */
/**
 * 合并区间
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function (intervals) {
    // 思路：将intervals按起始位置升序排序，判断两个区间是否有重合
    if (intervals.length === 0) return [];
    intervals.sort((a, b) => a[0] - b[0]);
    let res = [intervals[0]];
    for (let i = 1; i < intervals.length; i++) {
        let temp = merge(res[res.length - 1], intervals[i]);
        if (temp) {
            // 重合，替换
            res[res.length - 1] = temp;
        } else {
            // 不重合，追加
            res.push(intervals[i]);
        }
    }
    return res;
    // 合并两个区间
    function merge(a, b) {
        // 判断重合
        if (a[1] < b[0] || a[0] > b[1]) return null;
        return [Math.min(a[0], b[0]), Math.max(a[1], b[1])];
    }
}