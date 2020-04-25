//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=860 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * 
 * 链接：https://leetcode-cn.com/problems/lemonade-change
 */
class Solution {

    /**
     * 写法一
     * @param Integer[] $bills
     * @return Boolean
     */
    function lemonadeChange1($bills) {
        $prices = [10 => 0, 5 => 0];
        foreach ($bills as $bill) {
            if ($bill > 5) {
                $sub = $bill - 5;
                foreach ($prices as $price=>$count) {
                    $num = intdiv($sub, $price);
                    if ($count >= $num) {
                        $sub %= $price; 
                        $prices[$price] -= $num;
                    }
                }
                if ($sub > 0) return false; 
            }
            $bill < 20 && $prices[$bill]++;
        }
        return true;
    }

    /**
     * 写法二(贪心法)
     * 时间复杂度：O(N)，其中 N 是 bills 的长度。
     * 空间复杂度：O(1)。
     * @param Integer[] $bills
     * @return Boolean
     */
    function lemonadeChange2($bills) {
        $p5 = $p10 = 0;
        foreach ($bills as $bill) {
            if ($bill == 5) $p5++;
            else if ($bill == 10) {
                if ($p5 < 1) return false;
                $p5--;
                $p10++;
            } else {//20
                if ($p5 > 0 && $p10 > 0) {
                    $p5--;
                    $p10--;
                } else if ($p5 >= 3) {
                    $p5 -= 3;
                } else return false;
            }
        }
        return true;
    }
    //极简贪心写法
    function lemonadeChange($bills) {
        $p5 = $p10 = 0;
        foreach ($bills as $bill) {
            if ($bill == 5) $p5++;
            else if ($bill == 10) {
                $p5--;
                $p10++;
            } else if ($p10 > 0) {//20
                $p5--;
                $p10--;
            } else {
                $p5 -= 3;
            }
            if ($p5 < 0) return false;
        }
        return true;
    }

}
// @lc code=end
