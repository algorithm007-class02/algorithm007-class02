//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=621 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 621. 任务调度器
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 
 * 你需要计算完成所有任务所需要的最短时间。
 * 示例 ：
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
 *  
 * 提示：
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 * 
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 */
class Solution {

    /**
     * @param String[] $tasks
     * @param Integer $n
     * @return Integer
     * https://leetcode-cn.com/problems/task-scheduler/solution/python-xiang-jie-by-jalan/
     */
    function leastInterval($tasks, $n) {
        $len = count($tasks);
        if ($len <= 1) return $len;
        $counts = array_count_values($tasks);
        arsort($counts);
        $max_task_count = current($counts);
        $res = ($max_task_count - 1) * ($n + 1);
        foreach($counts as $task=>$count) {
            if ($count == $max_task_count) {
                $res++;
            }
        }
       return $res >= $len ? $res : $len;
    }
}
// @lc code=end
