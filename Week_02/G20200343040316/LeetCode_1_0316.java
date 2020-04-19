package com.wxs.algorithm1.week02;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-22
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_1_0316 {


    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int sum = target - nums[i];

            if(map.containsKey(sum)){
                return new int[]{map.get(sum),i};
            }

            map.put(nums[i],i);

        }


        return null;


    }


}
