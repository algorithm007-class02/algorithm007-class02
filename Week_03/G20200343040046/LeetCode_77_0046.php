<?php

class Solution {

    /**
     * @param Integer $n
     * @param Integer $k
     * @return Integer[][]
     */
    // function combine($n, $k) {
        
    // 	$res = [];

    // 	for($i = 1; $i <= $n; $i++) {
    // 		$temp = [];

    // 		while (count($temp) <= $k) {
    // 			# code...
    // 			$j = $i;
    // 			$temp[] = $j;
    // 			$j++;
    // 		}

    // 		$res[] = $temp;
    // 	}

    // 	return $res;

    // }
    

    protected $result = [];
    /**
     * @param Integer $n
     * @param Integer $k
     * @return Integer[][]
     */
    function combine($n, $k) {
        if ($n <= 0 || $k <= 0 || $k > $n) return [];
        $this->helper($n, $k, [], 1);
        return $this->result;
    }

    private function helper($n, $k, $list, $start)
    {
        if (count($list) == $k) {
            $this->result[] = $list;
            return;
        }

        // 此时剩余可选数字个数 $n - $i + 1
        // 所需数字个数 $k - count($list)
        for ($i = $start; $n - $i + 1 >= $k - count($list); ++$i) {
            $list[] = $i;
            $this->helper($n, $k, $list, $i + 1);
            array_pop($list);
        }
    }
}

// 自己写的暴力循环没成功，参考题解回溯，还得再整几遍

$test = new Solution();
var_dump($test->combine(4, 2));
