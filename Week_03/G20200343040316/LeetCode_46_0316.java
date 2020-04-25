package com.wxs.algorithm1.week03;

import java.util.ArrayList;
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

public class LeetCode_46_0316 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        int[] visited = new int[nums.length];

        backtrack(res,nums,new ArrayList<Integer>(),visited);


        return res;

    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {

        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if(visited[i] == 1){continue;}
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res,nums,tmp,visited);

            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }

    }

}
