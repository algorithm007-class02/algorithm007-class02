package com.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: welllu
 * @Date: 2020/3/28 19:25
 * @Description:
 */
public class LeeCode_77_0226 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<> ();
        travel(1, n, k, new ArrayList<Integer>(), result);
        return result;
    }

    private void travel(int start, int n,  int k, ArrayList<Integer> temp, List<List<Integer>> result) {
        //terminator
        if(temp.size() == k) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        //process data

        //sub probelms
        for (int i = start; i <= n; i ++) {
            temp.add(i);
            travel(i + 1, n, k, temp, result);
            temp.remove(temp.size() - 1);
        }
        //merge resulet

        //restore the current level

    }
}
