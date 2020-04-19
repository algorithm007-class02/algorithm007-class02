package com.logic;

import java.util.Arrays;

/**
 * @Auther: welllu
 * @Date: 2020/4/19 11:15
 * @Description:
 */
public class LeeCode_621_0226 {

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c: tasks) {
            map[c- 'A'] ++;
        }
        Arrays.sort(map);
        int maxTask = map[25] - 1;
        int allStep = maxTask * n;

        for(int i = 24;i >= 0 && map[i] > 0;i --) {
            System.out.println ( "before:" + allStep );
            allStep -= Math.min(maxTask,map[i]);
            System.out.println ( "end:" + allStep );
        }

        return allStep > 0 ? allStep + tasks.length : tasks.length;
    }
}
