class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        '''
        相同任务之间需要有n个单位的冷却时间，所以任务数最多的任务种类决定了耗时的基础长度
        n个单位的冷却时间意味着一整趟需要n+1个单位时间
        基础时间 = (最多任务数 - 1) * (n + 1)
        额外时间 = 并列任务数最多的任务种类数目 + 填充完冷却空档后还余下的任务数
        case 1: 任务可以完全填充进冷却空档中利用时间 - 如[AAAAAAABCDEFG], n = 2
        case 2: 任务数目大于冷却间隔数+1， 且填充冷却空档还有富裕 - 如[AAAAABBBCC], n = 2
        '''
        # if not tasks: return 0
        # import collections
        # ctr = collections.Counter("".join(tasks))
        # most = ctr.most_common(1)[0][1]
        # res = (most - 1) * (n + 1) + list(ctr.values()).count(most)
        # return max(res, len(tasks))

        
        # Version 2.0
        if not tasks: return 0
        taskMap = {}
        for task in tasks:
            taskMap[task] = taskMap.get(task, 0) + 1
        sortTasks = sorted(taskMap.items(), key=lambda x:x[1])
        res = (sortTasks[-1][1] - 1) * (n + 1)
        res += list(taskMap.values()).count(sortTasks[-1][1])
        return max(res, len(tasks))