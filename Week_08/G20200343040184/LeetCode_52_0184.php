//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=52 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 52. N皇后 II
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * 
 * 示例:
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *  
 * 提示：
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自 百度百科 - 皇后 ）
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    private $count = 0;
    /**
     * @param Integer $n
     * @return Integer
     */
    function totalNQueens($n) {
        if ($n < 1) return 0;
        $this->dfs($n, 0, 0, 0, 0);
        return $this->count;
    }
    function dfs($n, $row, $col, $pie, $na) {
        if ($n <= $row) {
            $this->count++;
            return;
        }
        //获取可以放置的位置
        $bits = (~($col | $pie | $na)) & ((1 << $n) - 1);
        while ($bits) {
            $p = $bits & -$bits;
            $bits &= $bits - 1;
            $this->dfs($n, $row + 1, $col | $p, ($pie | $p) << 1, ($na | $p) >> 1);
        }
    }
}
// @lc code=end
