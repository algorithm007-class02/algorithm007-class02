package com.logic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: welllu
 * @Date: 2020/4/19 17:09
 * @Description:
 */
public class LeeCode_403_0226 {
    // DP
    // a. 子问题，problem(i) = jump(i - k) or jump(i - k + 1) or jump(i - k - 1)
    // b. 状态，dp[i], 跳到第i步，所有方法
    // c. for loop [k - 1, k, k + 1]

    public boolean canCross(int[] stones) {
        HashMap<Integer,Set<Integer>> map = new HashMap<> ();
        for(int i = 0; i < stones.length; i ++) {
            map.put(stones[i],new HashSet<Integer> ());
        }
        map.get(0).add(0);
        for(int i = 0; i < stones.length; i ++) {
            for(int k: map.get(stones[i])) {
                for(int step = k - 1; step <= k + 1; step ++) {
                    if(step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}
