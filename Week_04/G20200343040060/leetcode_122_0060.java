package module01;

/**
 * @author JiaYunFei
 * @date 2020/4/1 21:00
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] nums = {5, 20,10,100};
        int res = MaxProfits(nums);
        System.out.println(res);
    }

    //贪心算法
    private static int MaxProfits(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp >= 0) {
                profit += tmp;
            }
        }
        return profit;
    }
}
