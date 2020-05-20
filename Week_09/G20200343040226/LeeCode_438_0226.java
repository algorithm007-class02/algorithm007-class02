package com.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: welllu
 * @Date: 2020/5/17 15:08
 * @Description:
 */
public class LeeCode_438_0226 {
    public List<Integer> findAnagrams(String s, String p) {

        char[] arrS = s.toCharArray ();
        char[] arrP = p.toCharArray ();

        List<Integer> ans = new ArrayList <> (  );
        int[] needs = new int[26];
        int[] window = new int[26];

        //init needs
        for(int i = 0; i < arrP.length; i ++) {
            needs[arrP[i] - 'a'] += 1;
        }

        int left = 0;
        int right = 0;
        while(right < arrS.length) {
            // move right and operate
            int curR = arrS[right] - 'a';
            right ++;
            window[curR] += 1;

            while(window[curR] > needs[curR]) {
                // move left and operate
                int curL = arrS[left] - 'a';
                left ++;
                window[curL] -= 1;
            }

            // store result
            if(right - left == arrP.length) {
                ans.add ( left );
            }
        }

        return ans;

    }
}
