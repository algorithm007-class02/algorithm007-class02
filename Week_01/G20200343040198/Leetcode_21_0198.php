<?php
/**
 * Created by PhpStorm.
 * User: Leaveone
 * Date: 2020/1/9
 * Time: 20:51
 */

class Leetcode210198 {
    //递归
    function mergeTwoLists($l1, $l2) {
        if($l1 !==null && $l2 !==null){
            if($l1->val > $l2->val){
                $temp=$l1;
                $l1=$l2;
                $l2=$temp;
            }
            $l1->next=$this->mergeTwoLists($l1->next,$l2);
        }
        return $l1??$l2;
    }
}