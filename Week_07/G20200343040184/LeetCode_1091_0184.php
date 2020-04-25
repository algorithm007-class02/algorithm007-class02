//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=1091 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 1091. 二进制矩阵中的最短路径
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 * 
 * 提示：
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    /**
     * bfs
     * @param Integer[][] $grid
     * @return Integer
     */
    function shortestPathBinaryMatrix1($grid) {
        $n = count($grid);
        $m = count($grid[0]);
        if ($grid[0][0] == 1 || $grid[$n - 1][$m - 1] == 1) return -1;
        $queue = [];
        $visited = [];
        $queue[] = [0, 0];
        $visited[0][0] = true;
        $ans = 0;
        $dx = [0, 1, 0, -1, -1, 1, -1, 1];
        $dy = [1, 0, -1, 0, -1, 1 , 1, -1];
        while ($queue) {
            $ans++;
            $size = count($queue);
            while ($size--) {
                [$x, $y] = array_shift($queue);
                //if ($x == $n - 1 && $y == $m - 1) return $ans;
                //8连通
                for ($i = 0; $i < 8; $i++) {
                    $nx = $x + $dx[$i];
                    $ny = $y + $dy[$i];
                    if ($nx >= 0 && $nx < $n && $ny >= 0 && $ny < $m 
                    && $grid[$nx][$ny] != 1 && !$visited[$nx][$ny]) {
                        if ($nx == $n - 1 && $ny == $m - 1) return $ans + 1;
                        $queue[] = [$nx, $ny];
                        $visited[$nx][$ny] = true;
                    }
                }
            }
        }
        return -1;
    }


    /**
     * A* search
     * @param Integer[][] $grid
     * @return Integer
     */
    function shortestPathBinaryMatrix($grid) {
        $n = count($grid);
        $m = count($grid[0]);
        if ($grid[0][0] == 1 || $grid[$n - 1][$m - 1] == 1) return -1;
        if ($n == 1) return 1;
        $pq = new SplMinHeap();
        $pq->insert([$grid[0][0] = 1, [0, 0, 1]]);
        $dx = [0, 1, 0, -1, -1, 1, -1, 1];
        $dy = [1, 0, -1, 0, -1, 1 , 1, -1];
        while ($pq->count()) {
            $current = $pq->current();
            $pq->next();
            [$x, $y, $step] = $current[1];
            //8连通
            for ($i = 0; $i < 8; $i++) {
                $nx = $x + $dx[$i];
                $ny = $y + $dy[$i];
                if ($nx == $n - 1 && $ny == $m - 1) return $step + 1;
                if ($nx < 0 || $nx >= $n || $ny < 0 || $ny >= $m) continue;
                if ($grid[$nx][$ny] != 0 && $grid[$nx][$ny] <= $step + 1) continue;
                $grid[$nx][$ny] = $step + 1;
                $p = max(abs($n - 1 - $nx), abs($n - 1 - $ny)) + $grid[$nx][$ny];
                $pq->insert([$p, [$nx, $ny, $grid[$nx][$ny]]]);
            }
        }
        return -1;
    }
}
// @lc code=end
