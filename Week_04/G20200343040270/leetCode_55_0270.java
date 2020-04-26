class Solution {

    /**
     * 贪心算法
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    public boolean canJump(int[] nums) {
        int lastPost = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; --i){
            if(i + nums[i] >= lastPost){
                lastPost = i;
            }
        }
        return lastPost == 0;
    }
}