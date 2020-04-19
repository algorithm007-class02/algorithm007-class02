import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start

// 1.哈希表存计数
// 2.排序，返回中间元素
// 3.摩尔投票

// class Solution {
//     public int majorityElement(int[] nums) {
//         // 哈希
//         Map<Integer, Integer> map = new HashMap<>();
//         int major = 0;
//         for (int num: nums){
//             if(!map.containsKey(num)){
//                 map.put(num, 1);
//             }else {
//                 map.put(num, map.get(num)+1);
//             }
//             if(map.get(num) > nums.length / 2){
//                 major = num;
//                 break;
//             }
//         }
//         return major;
//     }
// }

// public int majorityElement(int[] nums) {
//     // 排序
//     Arrays.sort(nums);
//     return nums[nums.length/2];
// }

class Solution {
    public int majorityElement(int[] nums) {
        // 摩尔投票
        int count = 0, major = 0;
        for (int i: nums){
            if(count == 0) major = i;
            if (i != major) count--;
            else count++;
        }
        return major;
    }
}

// @lc code=end

