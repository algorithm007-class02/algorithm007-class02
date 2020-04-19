package level2;

public class Solution55 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1 };
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 0)
            return false;
        int size = nums.length;
        int dist = 0;
        for (int i = 0; i < size; i++) {
            if (i <= dist) {
                dist = Math.max(dist, i + nums[i]);
            } else {
                break;
            }
        }
        return dist >= size - 1;
    }

    // 贪心算法 从最后一个位置开始反推 能继续的前提是前面的位置+位置的值大于最后位置的索引值
    public static boolean canJump2(int[] nums) {
        if (nums == null || nums.length <= 0)
            return false;
        int size = nums.length;
        int lastPos = size - 1;
        for (int i = size - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
