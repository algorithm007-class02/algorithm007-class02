package com.wxs.algorithm1;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-12
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_1_0316 {


    // 时间复杂度为 O(n^2) 空间复杂度为 O(1)
    public int[] twoSum(int[] nums, int target) {

        int[] total = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {

                    total[0] = i;
                    total[1] = j;
                }

            }
        }
        return total;

    }


    public int[] twoSum1(int[] nums, int target) {

        Map<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {

            int b = target - nums[i];

            if (maps.containsKey(b) && maps.get(b) != i) {
                return new int[]{i, maps.get(b)};
            }
        }

        throw new IllegalArgumentException("No two sum ");
    }


    // 时间复杂度 O(N), 空间复杂度 o(n)
    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> maps = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {

            int b = target - nums[i];

            if(maps.get(b) != null){
                return new int[]{i, maps.get(b)};
            }
            maps.put(nums[i],i);

        }

        throw new IllegalArgumentException("No two sum ");
    }


    public int[] twoSum3(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap();


        for (int i = 0; i < nums.length; i++) {

            int b = target  - nums[i];

            if(map.get(b) != null){
                return new int[]{i,map.get(b)};
            }
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("no two sum");

    }



}
