<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    function rotate(&$nums, $k) {
    	$k = fmod($k, count($nums));
    	$this->reverse($nums, 0, count($nums) - 1);
    	$this->reverse($nums, 0, $k - 1);
    	$this->reverse($nums, $k, count($nums) - 1);
    }


    function reverse(&$nums, $start, $end) {
    	while ($start < $end) {
    		# code...
    		$tmp = $nums[$start];
    		$nums[$start] = $nums[$end];
    		$nums[$end] = $tmp;
    		$start++;
    		$end--;
    	}
    }
}

$solution = new Solution();
$test = [1, 2, 3, 4, 5, 6, 7];
$solution->rotate($test, 3);
var_dump($test);