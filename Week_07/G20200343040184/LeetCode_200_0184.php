//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=200 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 200. 岛屿数量 [中等]
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=200 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 200. 岛屿数量
 * 链接：https://leetcode-cn.com/problems/number-of-islands/
 */
class UF {
    /**
     * @var array
     */
    private $parent = [];
    /**
     * @var array
     */
    private $rank = [];
    private $count = 0;
    public function __construct($grid)
    {
        $n = count($grid);
        $m = count($grid[0]);
        for ($i = 0; $i < $n; $i++) {
            for ($j = 0; $j < $m; $j++) {
                if ($grid[$i][$j] == 1) {
                    $this->parent[] = $i * $n + $j;
                    $this->count++;
                } else {
                    $this->parent[] = -1;
                }
                $this->rank[] = 0;
            }
        }
    }
    public function union($x, $y)
    {
        $rootx = $this->find($x);
        $rooty = $this->find($y);
        if ($rootx != $rooty) {
            if ($this->rank[$rootx] > $this->rank[$rooty]) {
                $this->parent[$rooty] = $rootx;
            } else {
                $this->parent[$rootx] = $rooty;
                if ($this->rank[$rootx] == $this->rank[$rooty]) 
                    $this->rank[$rooty]++;
            }
            $this->count--;
        }
    }

    public function find($i) {
        while ($this->parent[$i] != $i) {
            $this->parent[$i] = $this->parent[$this->parent[$i]];
            $i = $this->parent[$i];
        }
        return $this->parent[$i];
    }

    public function getCount()
    {
        return $this->count;
    }
}
class Solution {
    /**
     * @param String[][] $grid
     * @return Integer
     */
    function numIslands($grid)
    {
        $n = count($grid);
        if ($n == 0) return 0;
        $m = count($grid[0]);
        $uf = new UF($grid);
        $dx = [0, 1, 0, -1];
        $dy = [1, 0, -1, 0];
        for ($i = 0; $i < $n; ++$i) {
            for ($j = 0; $j < $m; ++$j) {
                if ($grid[$i][$j] == '1') {
                    $grid[$i][$j] = '0';
                    for ($k = 0; $k < 4; $k++) {
                        $ni = $i + $dx[$k];
                        $nj = $j + $dy[$k];
                        if ($ni >= 0 && $ni < $n && $nj >= 0 && $nj < $m && $grid[$ni][$nj] == '1') {
                            $uf->union($i * $n + $j, $ni * $n + $nj);
                        }
                    }
                }
            }
        }
        return $uf->getCount();
    }
}
// @lc code=end
