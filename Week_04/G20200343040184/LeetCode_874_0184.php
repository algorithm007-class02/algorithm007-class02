//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=874 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 874. 模拟行走机器人
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * 
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 
 * 在网格上有一些格子被视为障碍物。
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * 返回从原点到机器人的最大欧式距离的平方。
 * 
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 */
class Solution {

    /**
     * @param Integer[] $commands
     * @param Integer[][] $obstacles
     * @return Integer
     */
    function robotSim($commands, $obstacles) {
        $dx = [0, 1, 0, -1];
        $dy = [1, 0, -1, 0];
        $map = [];
        foreach ($obstacles as $obstacle) $map[implode(',', $obstacle)] = true;
        $ans = $x = $y =  $di = 0;
        foreach ($commands as $command) {
            if ($command == -2) {//向左转 90 度
                $di = ($di + 3) % 4;
            } else if ($command == -1) { //向右转 90 度
                $di = ($di + 1) % 4;
            } else {//移动步数
                for ($k = 0; $k < $command; $k++) {
                    $nx = $x + $dx[$di]; 
                    $ny = $y + $dy[$di];
                    if (!$map["{$nx},{$ny}"]) {//不是墙壁
                        $x = $nx;
                        $y = $ny;
                        $ans = max($ans, $x * $x + $y * $y);
                    }
                }
            }
        }
        return $ans;
    }
}
// @lc code=end
