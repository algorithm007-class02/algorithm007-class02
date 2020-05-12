# 排序后双指针单次遍历
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) <= 1: return intervals
        # intervals = sorted(intervals, key = lambda x:x[0])
        # res, tmp = [], intervals[0]
        # for i in range(1, len(intervals)):
        #     if intervals[i][0] <= tmp[1]:
        #         tmp[1] = max(intervals[i][1], tmp[1])
        #     else:
        #         res.append(tmp)
        #         tmp = intervals[i]
        # res.append(tmp)
        # return res

        intervals.sort(key=lambda x: x[0])
        res = []
        for interval in intervals:
            if not res or res[-1][1] < interval[0]:
                res.append(interval)
            else:
                res[-1][1] = max(interval[1], res[-1][1])
        return res