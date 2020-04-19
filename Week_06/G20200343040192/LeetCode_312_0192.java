class Solution {
  public static int maxCoins(int[] nums) {
    //避免空指针异常
    if (nums == null) {
      return 0;
    }

    //创建虚拟边界
    int length = nums.length;
    int[] nums2 = new int[length + 2];
    System.arraycopy(nums, 0, nums2, 1, length);
    nums2[0] = 1;
    nums2[length + 1] = 1;
    length = nums2.length;

    //创建dp表
    length = nums2.length;
    int[][] dp = new int[length][length];

    //开始dp：i为begin，j为end，k为在i、j区间划分子问题时的边界
    for (int i = length - 2; i > -1; i--) {
      for (int j = i + 2; j < length; j++) {
        //维护一个最大值；如果i、j相邻，值为0
        int max = 0;
        for (int k = i + 1; k < j; k++) {
          int temp = dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j];
          if (temp > max) {
            max = temp;
          }
        }
        dp[i][j] = max;
      }
    }
    return dp[0][length-1];
  }
}