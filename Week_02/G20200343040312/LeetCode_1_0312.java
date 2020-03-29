//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

/*
* 查看解答前的思考;
*   1. 方法一，双指针两重循环，不重复---可以根据循环变量起始位置来规避重复，这样还可以避免进“是否重复”的判断
*       即，直接使用j=i+1避免了i==j的判断,而使用i<nums.length-1是为了避免j=i+1溢出
*   2. 短时间内没有想出时间复杂度更短的方法，但根据题目提示应该与哈希表有关，自己还不太会使用它
* */

/**
* 查看解答后的思考：
*   1.一遍哈希表
*   2.两边哈希表
*   （哈希表的知识有待学习，暂放[mark],该标志用于快速搜索）
*   3.根据官方题解，自己应该要考虑地更加周全---当没有结果时要抛出错误。即使题目中说“假设每种输入只会对应一个答案”
*
*   fixMark:
*   1. 哈希表其实用起来很简单嘛，学习过程详见题目409的注释
*   2. 一遍哈希表就ok
* */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] twoSum(int[] nums, int target) {
        /*
         * 方法一，双指针*/
//        int[] position = new int[2];
//        boolean flag = false;
//
//        for (int i=0; i<nums.length-1; i++){
//            for (int j=i+1; j<nums.length; j++){
//                //找到答案后立刻
//                if (nums[j]==(target-nums[i])){
//                    position[0]=i;
//                    position[1]=j;
//                    flag=true;
//                    break;
//                }
//            }
//            if (flag==true){
//                break;
//            }
//        }
//        return position;
        /*
         * 耗时71ms左右（13%），使用内存39.6M（5%）,双指针必然低效*/

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diffence = target - nums[i];
            if (map.containsKey(diffence)) {
                return new int[]{map.get(diffence), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
        /**
         * 直接将数组的值（当做key）与下标（当做Value）放入Map中，然后利用map.containsKey()逐个查询Map中是否有值与差值相符*/
    }
}