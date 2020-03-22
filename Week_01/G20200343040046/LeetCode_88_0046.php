<?php

class Solution {

    /**
     * @param Integer[] $nums1
     * @param Integer $m
     * @param Integer[] $nums2
     * @param Integer $n
     * @return NULL
     */
    function merge(&$nums1, $m, $nums2, $n) {
    	
    	$p = $m + $n - 1;
    	while ($n > 0) {
    		# code...
    		if ($m <= 0 || $nums2[$n - 1] >= $nums1[$m - 1]) {
    			# code...
    			$nums1[$p--] = $nums2[$n - 1];
    			$n--;
    		}else {
    			$nums1[$p--] = $nums1[$m - 1];
    			$m--;
    		}
    	}

    	return ;

    }



    // function merge1(&$nums1, $m, $nums2, $n) {

    // 	$p = $m + $n - 1;

    // 	if ($nums1[$m - 1] <= $nums2[0]) {
    // 		# code...
    // 		for ($i = 0; $i < $n; $i++) { 
    // 			# code...
    // 			$nums1[$m + $i] = $nums2[$i];
    // 		}
    // 	}else {


    		

    // 	}
    // }
}

$solution = new Solution();
$num1 = [1, 2, 3, 0, 0, 0];
$num2 = [2, 5, 6];

$solution->merge($num1, 3, $num2, 3);
var_dump($num1);