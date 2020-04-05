package com.logic;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: welllu
 * @Date: 2020/4/4 19:12
 * @Description:
 */
public class LeeCode_874_0226 {
    private static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set =  new HashSet <> (  );
        for(int[] obstacle: obstacles) {
            set.add(obstacle[0] + " " + obstacle[1]);
        }
        int x = 0,y = 0,direction = 1,maxDistance = 0;
        for (int i = 0; i < commands.length ; i ++) {
            if(commands[i] == -2) {
                direction --;
                if(direction < 0) {
                    direction += 4;
                }
            }else if(commands[i] == -1) {
                direction ++;
                direction %= 4;
            }else{
                int step = 0;
                while( step < commands[i] && (!set.contains ( (x + directions[direction][0]) + " " + (y + directions[direction][1])))){
                    x += directions[direction][0];
                    y += directions[direction][1];
                    step ++;
                }

            }
            maxDistance = Math.max(maxDistance, x * x + y * y);
        }
        return maxDistance;
    }

}
