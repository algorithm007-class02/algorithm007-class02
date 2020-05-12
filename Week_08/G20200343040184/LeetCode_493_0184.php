//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=493 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 493. 翻转对
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 你需要返回给定数组中的重要翻转对的数量。
 * 
 * 示例 1:
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 
 * 示例 2:
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 * 
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function reversePairs($nums) {
        return $this->mergesort($nums, 0, count($nums) - 1);
        return $this->mergesort_and_count($nums, 0, count($nums) - 1);
    }

    /**
     * 参考链接
     * https://leetcode.com/problems/reverse-pairs/discuss/97306
     * @param [type] $nums
     * @param [type] $start
     * @param [type] $end
     * @return int
     */
    function mergesort(&$nums, $start, $end) {
        if ($start >= $end) return 0;
        $mid = $start + (($end - $start) >> 1);
        $count = $this->mergesort($nums, $start, $mid) + $this->mergesort($nums, $mid + 1, $end);
        $cache = [];
        $i = $t = $start;
        $c = 0;
        for ($j = $mid + 1; $j <= $end; $j++, $c++) {
            while ($i <= $mid && $nums[$i] <= 2 * $nums[$j]) $i++;
            while ($t <= $mid && $nums[$t] < $nums[$j]) $cache[$c++] = $nums[$t++];
            $cache[$c] = $nums[$j];
            $count += $mid - $i + 1;
        }
        while ($t <= $mid) $cache[$c++] = $nums[$t++];
        for ($i = 0; $i < $c; $i++) {
            $nums[$start + $i] = $cache[$i];
        } 
        return $count;
    }

    function mergesort_and_count(&$nums, $start, $end) {
        if ($start >= $end) return 0;
        //$mid = ($start + $end) >> 1;
        $mid = $start + (($end - $start) >> 1);
        $count = $this->mergesort_and_count($nums, $start, $mid) + $this->mergesort_and_count($nums, $mid + 1, $end);
        $j = $mid + 1;
        for ($i = $start; $i <= $mid; $i++) {
            while ($j <= $end && $nums[$i] > $nums[$j] * 2) $j++;
            $count += $j - ($mid + 1);
        }
        $this->merge($nums, $start, $mid, $end);
        return $count;
    }

    function merge(&$nums, $start, $mid, $end) {
        $n1 = $mid - $start + 1;
        $n2 = $end - $mid;
        $l = $r = [];
        for ($i = 0; $i < $n1; $i++) $l[$i] = $nums[$start + $i];
        for ($i = 0; $i < $n2; $i++) $r[$i] = $nums[$mid + 1 + $i];
        for ($i = 0, $j = 0, $k = $start; $k <= $end; $k++) {
            if ($j >= $n2 || ($i < $n1 && $l[$i] < $r[$j])) {
                $nums[$k] = $l[$i++];
            } else {
                $nums[$k] = $r[$j++];
            }
        }
    }
}
// @lc code=end
