package level3;

public class Solution45 {
    public static void main(String[] args) {

    }

    // 假设你总是可以到达数组的最后一个位置
    public int jump(int[] nums) {
        int size = nums.length;
        int start = 0;
        int end = 1;
        int count = 0;
        while (end < size) {
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end;
            end = maxPos + 1;
            count += 1;
        }
        return count;
    }

    public int jump2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int cur_max_index = nums[0];// 当前可达到的最远位置
        int pre_max_index = nums[0];// 遍历各个位置的过程中可达到的最远距离
        int min_jump = 1;
        for (int i = 1; i < nums.length; i++) {
            if (i > pre_max_index) {// 如果i无法再向前，那么在cur_max_index位置之前需要一次跳跃
                pre_max_index = cur_max_index;
                min_jump++;
            }
            if (i + nums[i] > cur_max_index) {
                cur_max_index = nums[i] + i;
            }
        }
        return min_jump;
    }
}
