//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=51 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 51. N皇后
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 提示：
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自 百度百科 - 皇后 ）
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    private $res = [];
    /**
     * @param Integer $n
     * @return String[][]
     */
    function solveNQueens($n) {
        if ($n < 1) return [];
        $this->dfs($n, 0, 0, 0, 0);
        return $this->res;
    }
    
    function dfs($n, $row, $cols, $pie, $na, $pick = []) {
        if ($n <= $row) {
            $res = [];
            foreach ($pick as $col) {
                for ($i = 0; $i < $n; $i++) {
                    if ($col & (1 << $i)) {
                        $res[] = str_pad('', $i, '.') . 'Q' . str_pad('', $n - $i - 1, '.');
                        break;
                    }
                }
            }
            $this->res[]  = $res;
            return;
        }
        $bits =  (~($cols | $pie | $na)) & ((1 << $n) - 1);
        while ($bits) {
            $p = $bits & -$bits;
            $pick[$row] = $p;
            $this->dfs($n, $row + 1, $cols | $p, ($pie | $p) << 1, ($na | $p) >> 1, $pick);
            $bits = $bits & ($bits - 1);
        }
    }
}
// @lc code=end
