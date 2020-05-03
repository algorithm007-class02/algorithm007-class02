//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=130 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 130. 被围绕的区域 [中等]
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class UF {
    private $parent = [];
    public function __construct($m)
    {
        for ($i = 0; $i < $m; $i++) {
            $this->parent[$i] = $i; 
        }
    }

    public function union($x, $y) {
        $rootx = $this->find($x);
        $rooty = $this->find($y);
        if ($rootx != $rooty) {
            $this->parent[$rootx] = $rooty;
        }
    }

    public function find($x) {
        while ($this->parent[$x] != $x) {
            $this->parent[$x] = $this->parent[$this->parent[$x]];
            $x = $this->parent[$x];
        }
        return $this->parent[$x];
    }

    public function isConnected($x, $y) {
        return $this->find($x) == $this->find($y);
    }
}
class Solution {

    /**
     * 并查集
     * @param String[][] $board
     * @return NULL
     */
    function solve(&$board) {
        $n = count($board);
        if($n==0)    return;
        $m = count($board[0]);
        $uf = new UF($n * $m + 1);
        $dummy = $n * $m;
        for($i = 0; $i< $n; $i++){
            for($j = 0; $j < $m; $j++){
                $node = $i * $m + $j; //为什么是 乘以列的长度
                if(($i == 0||$i == $n - 1|| $j == 0|| $j == $m - 1) && $board[$i][$j]=='O') 
                    $uf->union($node, $dummy);
                else if($board[$i][$j]=='O') {
                    if($board[$i - 1][$j]=='O') $uf->union($node, ($i - 1)* $m + $j);
                    if($board[$i + 1][$j]=='O') $uf->union($node, ($i + 1)* $m + $j);
                    if($board[$i][$j - 1]=='O') $uf->union($node, $i * $m + $j - 1);
                    if($board[$i][$j + 1]=='O') $uf->union($node, $i * $m + $j + 1);
                }
            }
        }
        
        for($i = 0; $i < $n; $i++){
            for($j = 0;$j < $m; $j++){
                if(!$uf->isConnected($i * $m+ $j, $dummy)){
                    $board[$i][$j]='X';
                }
            }
        }
    }

    /**
     * @param String[][] $board
     * @return NULL
     */
    function solve1(&$board) {
        $n = count($board);
        if ($n == 0) return;
        $m = count($board[0]);
        for ($i = 0; $i < $n; $i++) {
            for ($j = 0; $j < $m; $j++) {
                $is_edge = $i == 0 || $j == 0 || $i == $n - 1 || $j == $m - 1;
                if ($board[$i][$j] == 'O' && $is_edge) {
                    $this->bfs($board, $i, $j, $n, $m);
                }
            }
        }
        for ($i = 0; $i < $n; $i++) {
            for ($j = 0; $j < $m; $j++) {
                if ($board[$i][$j] == 'O') $board[$i][$j] = 'X';
                else if ($board[$i][$j] == '#')  $board[$i][$j] = 'O';
            }
        }
    }

    function dfs(&$board, $x, $y, $n, $m) {
        $board[$x][$y] = '#';
        $dx = [0, 1, 0, -1];
        $dy = [1, 0, -1, 0];
        for ($i = 0; $i < 4; $i++) {
            $nx = $x + $dx[$i];
            $ny = $y + $dy[$i];
            if ($nx >= 0 && $nx < $n && $ny >= 0 && $ny < $m && $board[$nx][$ny] == 'O') {
                $this->dfs($board, $nx, $ny, $n, $m);
            }
        }
    }

    function bfs(&$board, $x, $y, $n, $m) {
        $board[$x][$y] = '#';
        $queue = [];
        $queue[] = [$x, $y];
        $dx = [0, 1, 0, -1];
        $dy = [1, 0, -1, 0];
        while ($queue) {
            [$x, $y] = array_shift($queue);
            for ($i = 0; $i < 4; $i++) {
                $nx = $x + $dx[$i];
                $ny = $y + $dy[$i];
                if ($nx >= 0 && $nx < $n && $ny >= 0 && $ny < $m && $board[$nx][$ny] == 'O') {
                    $queue[] = [$nx, $ny];
                    $board[$nx][$ny] = '#';
                }
            }
        }
    }
}
// @lc code=end
