package com.wxs.algorithm1.week06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-19
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_120_0316 {


    public static void main(String[] args) {


        List<Integer> list1 = Arrays.asList(2);
        List<Integer> list2 = Arrays.asList(3,4);
        List<Integer> list3 = Arrays.asList(6,5,7);
        List<Integer> list4 = Arrays.asList(4,1,8,3);


        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);


        LeetCode_120_0316 minimumTotal120 = new LeetCode_120_0316();

        minimumTotal120.minimumTotal1(triangle);


    }


    public int minimumTotal(List<List<Integer>> triangle) {




        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0;  j < triangle.get(i).size(); j++) {
                Integer sum = triangle.get(i).get(j);
                triangle.get(i).set(j,sum += Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }

        return triangle.get(0).get(0);

    }


    public int minimumTotal1(List<List<Integer>> triangle) {


        int[] arr = new int[triangle.size()+1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0;  j < triangle.get(i).size(); j++) {
                arr[j] = Math.min(arr[j],arr[j+1])+triangle.get(i).get(j);
            }
        }

        return arr[0];

    }

    int depth;


    // 至顶到下递归
    public int minimumTotal2(List<List<Integer>> triangle) {

        depth = triangle.size();


        return helper(0,0, triangle);





    }

    private int helper(int level, int triLevel, List<List<Integer>> triangle) {

        if(level == depth - 1){
            return triangle.get(level).get(triLevel);
        }
        int left = helper(level + 1,triLevel,triangle);
        int right = helper(level+1,triLevel+1,triangle);
        return Math.min(left,right)+triangle.get(level).get(triLevel);
    }




    int[][] memb;

    // 至顶到下递归 ,优化记忆化搜索
    public int minimumTotal3(List<List<Integer>> triangle) {

        depth = triangle.size();
        memb = new int[triangle.size()][triangle.size()];
        return helper2(0,0, triangle);

    }

    private int helper2(int level, int triLevel, List<List<Integer>> triangle) {

        if(level == depth - 1){
            return triangle.get(level).get(triLevel);
        }

        if(memb[level][triLevel] !=0){
            return memb[level][triLevel];
        }

        int left = helper(level + 1,triLevel,triangle);
        int right = helper(level+1,triLevel+1,triangle);

        memb[level][triLevel] = Math.min(left,right)+triangle.get(level).get(triLevel);

        return memb[level][triLevel];
    }

}
