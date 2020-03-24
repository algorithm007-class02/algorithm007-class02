import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode_1_0014
 */
public class LeetCode_1_0014 {

    public static void main(String[] args) {
        

    }

    public int[] twoSum(int[] nums,int tatget){
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = tatget - nums[i]; 
            if (map.containsKey(key)) {
                res[0] = i;
                res[1] = map.get(key);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}