//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=547 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 547. 朋友圈 [中等]
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * 
 * 示例 1:
 * 输入: 
 * [
 *  [1,1,0],
 *  [1,1,0],
 *  [0,0,1]
 * ]
 * 输出: 2 
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 
 * 示例 2:
 * 输入: 
 * [
 *  [1,1,0],
 *  [1,1,1],
 *  [0,1,1]
 * ]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 注意：
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friend-circles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution
{
    private $parent = [];
    private $rank = [];
    private $count; 
    /**
     * @param String[][] $grid
     * @return Integer
     */
    function findCircleNum($grid)
    {
        if (empty($grid)) return 0;
        $this->count = $m = count($grid);
        for ($i = 0; $i < $m; $i++) {
            $this->parent[$i] = $i;
            $this->rank[$i] = 0;
        }
        for ($i = 0; $i < $m - 1; $i++) {
            for ($j = $i + 1; $j < $m; $j++) {
                if ($i != $j && $grid[$i][$j] == 1) {
                    $this->union($i, $j);
                }
            }
        }
       return $this->count;
    }
    function union ($i, $j) {
        $rooti = $this->find($i);
        $rootj = $this->find($j);
        if ($rooti != $rootj) {
            if ($this->rank[$rooti] > $this->rank[$rootj]) {
                $this->parent[$rootj] = $rooti;
            } else {
                $this->parent[$rooti] = $rootj;
                if ($this->rank[$rooti] == $this->rank[$rootj]) 
                    $this->rank[$rootj]++;
            }
            $this->count--;
        }
    }
    function find($i) {
        // if ($this->parent[$i] != $i) {
        //     $this->parent[$i] = $this->find($this->parent[$i]);
        // }
        while ($this->parent[$i] != $i) {
            $this->parent[$i] = $this->parent[$this->parent[$i]];
            $i = $this->parent[$i];
        }
        return $this->parent[$i];
    }
}
// @lc code=end
