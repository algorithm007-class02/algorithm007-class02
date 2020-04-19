<?php

class Solution {

    /**
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs) {
        
    	$result = [];

    	foreach($strs as $val) {
    		$temp = $this->returnAfterSort($val);
    		$result[$temp][] = $val;
    	}

    	return array_values($result);

    }


    /**
     * 先给字符排序
     */
    function returnAfterSort($str) {

    	$strArr = str_split($str);
    	asort($strArr);

    	return implode('', $strArr);

    }
}



class Solution1 {

    /**
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs) {
        
    	$result = [];

    	foreach($strs as $val) {
    		$temp = $this->returnOrdSum($val);
    		$result[$temp][] = $val;
    	}
    	
    	return array_values($result);

    }


    function returnOrdSum($str) {

    	$ordArr = [];
    	$len = strlen($str);

    	for ($i=0; $i < $len; $i++) { 
    		# code...
    		$ordArr[] = ord($str[$i]);
    	}

    	sort($ordArr);

    	return implode('', $ordArr);

    }
}



$solution1 = new Solution1();

$test = ["cab","tin","pew","duh","may","ill","buy","bar","max","doc"];

var_dump($solution1->groupAnagrams($test));
