<?php
/**
 * Created by PhpStorm.
 * User: Leaveone
 * Date: 2020/1/10
 * Time: 19:59
 */

class Leetcode880198 {
    function merge(&$nums1, $m, $nums2, $n) {
        $nums1= array_merge(array_slice($nums1 , 0,$m),array_slice($nums2,0,$n));
        sort($nums1);
    }
}
