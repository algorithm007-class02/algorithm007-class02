import jdk.internal.org.objectweb.asm.tree.IincInsnNode;

import java.util.HashMap;

/**
 * @Auther: yys
 * @Date: 2020/3/12 17:27
 * @Description:
 */

//一遍hash
public class Solution2 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i <nums.length ; i++) {

            int anotherNums = target-nums[i];
            if (map.containsKey(anotherNums)){

                return new int[]{map.get(anotherNums),i};
            }
            map.put(nums[i],i);

        }
        throw new IllegalArgumentException();
    }
}
