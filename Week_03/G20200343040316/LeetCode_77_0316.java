package com.wxs.algorithm1.week03;

import java.util.LinkedList;
import java.util.List;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-29
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_77_0316 {


    public static void main(String[] args) {

        LeetCode_77_0316 combine77 = new LeetCode_77_0316();
        List<List<Integer>> combine = combine77.combine(4, 2);
        System.out.println(combine);

    }

    List<List<Integer>> list = new LinkedList<>();
    int n, k;


    public List<List<Integer>> combine(int n, int k) {

        this.n = n;
        this.k = k;

        backtrack(1, new LinkedList<Integer>());

        return list;

    }

    private void backtrack(int first, LinkedList<Integer> curr) {


        if (curr.size() == k) {
            list.add(new LinkedList<>(curr));
        }

        for (int i = first; i < n + 1; i++) {

            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }


    }

}
