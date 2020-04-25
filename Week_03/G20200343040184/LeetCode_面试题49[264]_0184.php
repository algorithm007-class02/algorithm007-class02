//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=264 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 264. 丑数 II
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii/
 */
//方法一：大顶堆
class Ugly {
    public $nums = [];
    function __construct()
    {
        $min_heap = new SplMinHeap();
        $min_heap->insert(1);
        $hash = [1 => true];
        foreach(range(1, 1690) as $k)  {
            $num = $min_heap->current();
            $this->nums[] = $num;
            $min_heap->next();
            foreach ([2, 3, 5] as $i) {
                $new = $num * $i;
                if (!$hash[$new]) {
                    $min_heap->insert($new);
                    $hash[$new] = true;
                }
            }
        }
    }
}
//方法二：动态规划
class UglyDp {
    public $nums = [1];
    function __construct()
    {
        $p2 = $p3 = $p5 = 0;
        foreach (range(1, 1690) as $k) {
            $num = min($this->nums[$p2] * 2, $this->nums[$p3] * 3, $this->nums[$p5] * 5);
            $this->nums[] = $num;
            if ($num == $this->nums[$p2] * 2) $p2++; 
            if ($num == $this->nums[$p3] * 3) $p3++; 
            if ($num == $this->nums[$p5] * 5) $p5++; 
        }
    }
}
class Solution {
    private static $ugly;
    function __construct()
    {
        if (!self::$ugly) 
            self::$ugly = new UglyDp();
    }
    /**
     * 
     * @param Integer $n
     * @return Integer
     */
    function nthUglyNumber($n) {
        return self::$ugly->nums[$n - 1];
    }
}
// @lc code=end
