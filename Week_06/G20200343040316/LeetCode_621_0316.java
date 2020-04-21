package com.wxs.algorithm1.week06;

import java.util.Arrays;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-19
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_621_0316 {

    public int leastInterval(char[] tasks, int n) {

        int[] map = new int[26];

        for (char task : tasks) {
            map[task - 'A']++;
        }
        Arrays.sort(map);
        //数量最多的指令
        int max_val = map[25] - 1;
        int idle_slots = max_val * n;


        for (int i = 24; i >=0 && map[i] > 0; i--) {

            idle_slots -= Math.min(map[i],max_val);

        }

        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;

    }

}
