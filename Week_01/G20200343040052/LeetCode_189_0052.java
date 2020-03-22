public class LeetCode_189_0052 {
    public void rotate(int[] nums, int k) {
        for(int i = 0; i < k; i++) {
            //暴力解法 旋转k次
            int last = nums[nums.length-1];
            int tmp = 0;
            for(int j = 0; j < nums.length; j++) {
                // 数组的最后一个值移动到数组的第一个剩下的每一个值往后移动一位
                tmp = nums[j];
                nums[j] = last;
                last = tmp;
            }
        }
    }
}
