/**  1 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> map = new HashMap<Integer,Integer>();
       for (int i = 0; i < nums.length; ++i) {
           map.put(nums[i], i);
       }
       int temp;
       for (int j = 0; j < nums.length; ++j) {
           temp = target - nums[j];
           if (map.containsKey(temp) && map.get(temp) != j) {
               return new int[] {map.get(temp), j};
           }
       }
       throw new IllegalArgumentException("No two sum solution");
    }
}

/*
*class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> map = new HashMap<>();
       int temp;
       for (int j = 0; j < nums.length; ++j) {
           temp = target - nums[j];
           if (map.containsKey(temp)) {
               return new int[] {map.get(temp), j};
           }
            map.put(nums[j], j);
       }
       throw new IllegalArgumentException("No two sum solution");
    }
}
*/