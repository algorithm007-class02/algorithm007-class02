//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=529 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 529. 扫雷游戏
 * 让我们一起来玩扫雷游戏！
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 * 
 * 链接：https://leetcode-cn.com/problems/minesweeper
 */
class Solution {

    /**
     * bfs
     * @param String[][] $board
     * @param Integer[] $click
     * @return String[][]
     */
    function updateBoard($board, $click) {
        $n = count($board);
        $m = count($board[0]);
        $queue = [$click];
        while ($queue) {
            [$x, $y] = array_shift($queue);
            if ($board[$x][$y] == 'M') {
                $board[$x][$y] = 'X';
            } else {
                //计算周围的地雷 8 个方向
                $count = 0;
                for ($i = -1; $i <= 1; $i++) {
                    for ($j = -1; $j <= 1; $j++) {
                        if ($i == 0 && $j == 0) continue;
                        $nx = $x + $i;
                        $ny = $y + $j;
                        if ($board[$nx][$ny] == 'M' || $board[$nx][$ny] == 'X') $count++;
                    }
                }
                if ($count > 0) {
                    $board[$x][$y] = (string)$count;
                } else {
                    $board[$x][$y] = 'B';
                    for ($i = -1; $i <= 1; $i++) {
                        for ($j = -1; $j <= 1; $j++) {
                            if ($i == 0 && $j == 0) continue;
                            $nx = $x + $i;
                            $ny = $y + $j;
                            if ($nx >=0 && $nx < $n && $ny >=0 && $ny < $m && $board[$nx][$ny] == 'E') {
                                $board[$nx][$ny] = 'B';
                                $queue[] = [$nx, $ny];
                            }
                        }
                    }
                }
            }
        }
        return $board;
    }
}
// @lc code=end
