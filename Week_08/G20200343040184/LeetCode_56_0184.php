//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=56 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    /**
     * @param Integer[][] $intervals
     * @return Integer[][]
     */
    function merge($intervals) {
        //排序
        array_multisort(array_column($intervals, 0), $intervals);
        $res = [];
        $i = -1;
        foreach ($intervals as $interval) {
            if ($i == -1 || $res[$i][1] < $interval[0]) {
                $res[++$i] = $interval;
            } else {
                $res[$i][1] = max($res[$i][1], $interval[1]);
            }
        }
        return $res;
    }
}
// @lc code=end
