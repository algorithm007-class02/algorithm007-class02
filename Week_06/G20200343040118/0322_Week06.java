class Solution {
    //动态规划
    public int coinChange(int[] coins, int amount) {
        int[] nums = new int[amount + 1];
        Arrays.fill(nums,amount+1);
        nums[0] = 0;
        for(int i = 1 ; i <= amount ; i++){
            for(int j = 0 ; j < coins.length ; j++){
                if(coins[j] <= i){
                    nums[i] = Math.min(nums[i] , nums[i-coins[j]]+1);
                }
            }
        }
        return nums[amount] == amount+1?-1:nums[amount];

    }
}