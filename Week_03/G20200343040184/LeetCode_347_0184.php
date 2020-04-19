//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=347 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 */
class Solution {

    /**
     * 方法一：小顶堆
     * @param Integer[] $nums
     * @param Integer $k
     * @return Integer[]
     */
    function topKFrequent1($nums, $k) {
        $map = array_count_values($nums);
        $min_heap = new SplMinHeap();
        foreach ($map as $num=>$count) {
            $min_heap->insert([$count, $num]);
            if ($min_heap->count() > $k) {
                $min_heap->next();
            }
        }
        $res = [];
        foreach($min_heap as $val) {
            $res[] = $val[1];
        }
        return $res;
    }

    /**
     * 方法二：优先级队列
     * @param Integer[] $nums
     * @param Integer $k
     * @return Integer[]
     */
    function topKFrequent2($nums, $k) {
        $counts = array_count_values($nums);
        $pq = new SplPriorityQueue();
        foreach ($counts as $num=>$count) {
            $pq->insert($num, $count);
        }
        $res = [];
        for($i = 0; $i < $k; $i++) {
            $res[] = $pq->extract();
        }
        return $res;
    }

    /**
     * 方法三：排序
     * @param Integer[] $nums
     * @param Integer $k
     * @return Integer[]
     */
    function topKFrequent($nums, $k) {
        $counts = array_count_values($nums);
        arsort($counts);
        $res = [];
        foreach ($counts as $num => $count) {
        	if(count($res) < $k){
        		$res[] = $num;
        	}
        }
        return $res;
    }
}
// @lc code=end
