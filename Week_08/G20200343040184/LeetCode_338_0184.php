//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=338 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 * 
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 
 * 进阶:
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    function count($n) {
        $count = 0;
        while ($n) {
            $count++;
            $n &= $n - 1;//拿掉最低位的1
        }
        return $count;
    }
    /**
     * 方法一
     * @param Integer $num
     * @return Integer[]
     */
    function countBits1($num) {
        $res = [0];
        for ($i = 1; $i <= $num; $i++) {
            $res[] = $this->count($i);
        }
        return $res;
    }

    /**
     * 方法二：两种dp状态转移方程
     * P(x)=P(x/2)+(xmod2)
     * P(x)=P(x&(x−1))+1
     * @param Integer $num
     * @return Integer[]
     */
    function countBits2($num) {
        $res = array_fill(0, $num + 1, 0);
        for ($i = 1; $i <= $num; $i++) {
            $res[$i] = $res[$i & ($i - 1)] + 1;
        }
        return $res;
    }

    /**
     * 方法三
     * @param Integer $num
     * @return Integer[]
     * https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
     */
    function countBits($num) {
        $res = array_fill(0, $num + 1, 0);
        for ($i = 1; $i <= $num; $i++) {
            if ($i & 1) {//奇数
                $res[$i] = $res[$i - 1] + 1;
            } else {
                $res[$i] = $res[$i >> 1];
            }
        }
        return $res;
    }
}
// @lc code=end
