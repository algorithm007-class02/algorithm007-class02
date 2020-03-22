<?php
/**
 * Created by PhpStorm.
 * User: Leaveone
 * Date: 2020/1/11
 * Time: 22:42
 */

class Leetcode10198 {
    //两层遍历
//    function twoSum($nums, $target) {
//        $len = count($nums);
//        for($i = 0;$i < $len;$i++){
//            for($j = 0;$j < $len;$j++){
//                if($nums[$i] + $nums[$j] == $target && $i !== $j){
//                    return [$i,$j];
//                }
//            }
//        }
//    }
    //三数之和 $target - $v + $v = $target
    function main($nums, $target) {
        $nums_match = [];
        foreach ($nums as $_k => $_v) {
            if (!isset($nums_match[$target - $_v])) {
                $nums_match[$target - $_v] = $_k;
            }
            if (isset($nums_match[$_v]) && $nums_match[$_v] != $_k) {
                return [
                    $_k,
                    $nums_match[$_v],
                ];
            }
        }
    }
}