import java.util.HashMap;
import java.util.Map;

//1 两数之和
//通过hash操作map方式优化暴力解决的方法
//通过遍历数组,取每个元素的值判断map是否有target-nums[i]的key
//如果有则记录,不存在则将(nums[i],i)存入mao,继续遍历
//复杂度O(n)
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("not exists");
    }
}
