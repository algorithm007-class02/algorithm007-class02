//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=37 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 37. 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 一个数独的解法需遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * 答案被标成红色。
 * Note:
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * 通过次数25,902提交次数42,403
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    /**
     * @param String[][] $board
     * @return NULL
     */
    function solveSudoku(&$board) {
        if (count($board) != 9 || count($board[0]) != 9) return false;
        //初始化
        $rows = $columns = $blocks = [];
        $nums = array_flip(range(1, 9));
        for ($i = 0; $i < 9; $i++) {
            $rows[$i] = $nums;
            $columns[$i] = $nums;
            $blocks[$i] = $nums;
        }
        //收集需要填数的位置
        $empty = [];
        for ($i = 0; $i < 9; $i++) {
            for ($j = 0; $j < 9; $j++) {
                if ($board[$i][$j] != '.') {
                    $num = $board[$i][$j];
                    $b = intval($i / 3) * 3 + intval($j / 3);
                    unset($rows[$i][$num], $columns[$j][$num], $blocks[$b][$num]);
                } else {
                    $empty[] = [$i, $j];
                }
            }
        }
        $this->backtrack($board, $empty, $rows, $columns, $blocks);
    }

    function backtrack(&$board, $empty, $rows, $columns, $blocks, $index = 0) {
        if ($index == count($empty)) {
            return true;
        }
        [$i, $j] = $empty[$index];
        $b = intval($i / 3) * 3 + intval($j / 3);
        $nums = array_intersect(array_keys($rows[$i]), array_keys($columns[$j]), array_keys($blocks[$b]));
        foreach ($nums as $num) {
            unset($rows[$i][$num], $columns[$j][$num], $blocks[$b][$num]);
            $board[$i][$j] = (string)$num;
            if ($this->backtrack($board, $empty, $rows, $columns, $blocks, $index + 1))
                return true;
            $rows[$i][$num] = $num;
            $columns[$j][$num] = $num;
            $blocks[$b][$num] = $num;
        }
        return false;
    }
}
// @lc code=end
