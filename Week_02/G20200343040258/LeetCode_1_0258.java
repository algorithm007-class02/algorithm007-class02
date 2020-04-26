/*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //一遍哈希
        Map<Integer,Integer> mapNums = new HashMap<Integer,Integer>();
        //只有一组
        for(int i = 0;i < nums.length;i ++){
            Integer index = mapNums.get(target - nums[i]);
            if(index != null){
                return new int[]{index,i};
            }
            mapNums.put(nums[i],i);
        }
        return null;

    }
}

//时间复杂度 O(n)
//空间复杂度：O(n)。