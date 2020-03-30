/**
 * 自己的map解法 较蠢
 */
class Solution {
  public int majorityElement(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i:nums) {
      Integer value = map.get(i);
      if (value != null) {
        map.put(i, value + 1);
      } else {
        map.put(i, 1);
      }
    }
    int max = 0;
    int result = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int num = entry.getValue();
      if(num > max)
      {
        max = num;
        result = entry.getKey();
      }
    }
    return result;
  }
}
/**
 * 排序三行解法 牛逼
 */
import java.util.Arrays;

class Solution {
  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length >> 1];
  }
}