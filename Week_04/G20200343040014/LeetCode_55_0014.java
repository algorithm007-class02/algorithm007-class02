class Solution {
    public boolean canJump(int[] nums) {
        int index = nums.length -1; //从最后一个位置开始
        for (int i = nums.length - 2; i >= 0; i --){
            if (nums[i] + i >= index){//如果前一位的前一位的位置+能跳的步数 能跳过当前位置
                index = i; //更新位置
            }
        }
        return index == 0;
    }
}