//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表


import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution560 {
    /**累计和+HashMap的方式，适用于求 对于任意整数组成的数组 求数组中和为k的连续子子树的个数
     * 只需要遍历一遍数组时间复杂度为O(n)*/
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int sum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for (int i=0; i<nums.length; i++){
            sum+=nums[i];
            if (map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    /*
     * 时间复杂度为O(n),空间复杂度为O(n)
     * 耗时19ms（95%），使用内存40.4M（8%）*/
}
//leetcode submit region end(Prohibit modification and deletion)
