<?php

class Leetcode2830198
{
    //method1
    //时间复杂度O(n)
    //空间复杂度O(1)
    function moveZeroes(&$nums) {
        for ($i = 0;$i< count($nums);$i++){
            if($nums[$i] == 0){
                unset($nums[$i]);
                array_push($nums,0);
            }
        }
        //foreach
//            foreach($nums as $key => $val){
//                if($nums[$key] == 0){
//                    unset($nums[$key]);
//                    $nums[] = 0;
//                }
//            }
    }
    //method2
    //时间复杂度O(n)
    //空间复杂度O(1)
//        function moveZeroes(&$nums) {
//            $len = count($nums);
//            $index = 0;
//            foreach ($nums as $key => $val){
//                if($val != 0){
//                    $nums[$index] = $nums[$key];
//                    $index++;
//                }
//            }
//            for (;$index < $len;$index++){
//                $nums[$index] = 0;
//            }
//        }
}