package com.logic;

import java.util.Arrays;

/**
 * @Auther: welllu
 * @Date: 2020/4/5 17:42
 * @Description:https://leetcode-cn.com/problems/assign-cookies/
 */
public class LeeCode_455_0226 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        while(child < g.length && cookie < s.length) {
            if(g[child] <= s[cookie])  child ++;
            cookie ++;
        }
        return child;
    }
}
