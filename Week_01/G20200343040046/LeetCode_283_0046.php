<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums) {
       
        foreach ($nums as $key => $val) {
            if ($val == 0) {
                unset($nums[$key]);
                $nums[] = 0;
            }
        }

        return $nums;
    }
}

$solution = new Solution();
$test = [0, 1, 0, 3, 5, 0, 12];
var_dump($solution->moveZeroes($test));