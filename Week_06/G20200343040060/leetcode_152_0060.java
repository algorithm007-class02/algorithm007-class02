public class MaxProduct_152 {
    public static void main(String[] args) {
        int[] nums = {-1, 1, 2, -1};
        int res = maxMultiply(nums);
        System.out.println(res);
    }

    private static int maxMultiply(int[] nums) {
        int min = nums[0], max = nums[0], res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp;
                temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            res = Math.max(res, max);

        }
        return res;
    }
}
