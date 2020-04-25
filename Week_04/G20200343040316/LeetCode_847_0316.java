package com.wxs.algorithm1.week04;

import java.util.HashSet;
import java.util.Set;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-05
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_847_0316 {

    public static void main(String[] args) {


        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};

        LeetCode_847_0316 robotSim847 = new LeetCode_847_0316();

        int i = robotSim847.robotSim(commands, obstacles);

        System.out.println(i);

    }

    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int robotSim(int[] commands, int[][] obstacles) {

        Set<String> obstaclesIndex = new HashSet<>();

        // 记录障碍物坐标
        for (int[] obstacle : obstacles) {
            obstaclesIndex.add(obstacle[0] + " " + obstacle[1]);
        }


        int x = 0, y = 0;
        int direction = 1; // 默认前进方向下标， 用来获取方向数组的的位置

       // int maxDistSquare = 0; // 最大斜边平方值

        for (int i = 0; i < commands.length; i++) {

            if (commands[i] == -2) {
                direction--;
                if (direction < 0) {
                    direction += 4; // 还是在方向数组中，确定方向，如果方向小于0后，数组越界
                }

            } else if (commands[i] == -1) {
                direction++;
                direction %= 4; // 同理，确定方向，并保证数组不越界
            } else {

                int step = 0;
                while (step < commands[i] && !obstaclesIndex.contains((x + directions[direction][0]) + " " + (y + directions[direction][1]))) {
                    x += directions[direction][0];
                    y += directions[direction][1];
                    step ++ ;
                }


               // maxDistSquare = Math.max(maxDistSquare,x * x + y * y);
            }

        }

        return x * x + y * y;
    }

}
