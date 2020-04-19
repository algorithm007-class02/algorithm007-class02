//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=455 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 455. 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * 
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 */
class Solution {

    /**
     * 方法一：贪心法
     * 时间复杂度：O(Nlog(N)) 排序算法的复杂度
     * 空间复杂度：O(1)O(1) 未申请额外的空间
     * @param Integer[] $g
     * @param Integer[] $s
     * @return Integer
     */
    function findContentChildren($g, $s) {
        sort($g);
        sort($s);
        $child = 0;
        for ($j = 0; $child < count($g) && $j < count($s); $j++) {
            if ($g[$child] <= $s[$j]) $child++;
        }
        return $child;
    }
}
// @lc code=end
