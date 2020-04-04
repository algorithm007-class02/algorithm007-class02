package com.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: welllu
 * @Date: 2020/3/28 19:31
 * @Description:
 */
public class LeeCode_47_0226 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> numsList = new ArrayList<>();
        for (int num: nums) {
            numsList.add(num);
        }

        bfs(0, nums.length, numsList, result);

        return result;
    }

    //1.顺序取数字，作为首数字
    //2.剩下的数字，多种方式排列
    //3.回溯
    private void bfs(int index, int n, List<Integer> nums, List<List<Integer>> result) {
        //terminator
        if (index == n) {
            if(!result.contains(nums))
                result.add(new ArrayList<Integer> (nums));
        }
        //process data

        //sub problems
        for( int i = index; i < n; i ++) {
            Collections.swap(nums, index, i);
            bfs(index + 1, n, nums, result);
            Collections.swap(nums, index, i);
        }
        //merge result

        //restore the current state

    }
}
