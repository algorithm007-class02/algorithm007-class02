package week02.g20200343040172;

import java.util.HashMap;

/**
 * LeetCode-1 Two Sum
 */
public class LeetCode_1_0172 {

    /**
     * 一遍哈希法：遍历的时候，先判断target-nums[i]是否存在于map中，存在则返回所存在的key对应的下标以及当前下标
     * a+b=target，在这数组中看能否找到a和b，若数组中有a和b，若a在下边为0的位置，b在其他任意位置
     * 第一次遍历，也就是下标为0的时候，此次map中没有任何元素，所以肯定匹配不成功，然后把a放进map，a作为key，当前的i作为value
     * 紧接着遍历到b的时候，由于a已经存放到了map中，肯定能target-b肯定能匹配成功，但是需要注意的是此时的b肯定是晚于a出现的，所以返回的时候a的下标在前
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
