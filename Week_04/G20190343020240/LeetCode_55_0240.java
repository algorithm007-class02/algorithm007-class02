class Solution {
    public boolean canJump(int[] nums) {
        //逆推法
        //倒数第二个位置开始进行判断，能否跳到目标位置，能跳到则更新目标位置，继续遍历
        //最后判断目标位置是否为第一个位置
        if(nums.length == 0) return false;
        int goal = nums.length - 1;
        for(int i = nums.length - 2;i >=0;i--){
            if(nums[i] + i >= goal){
                goal = i;
            }
        }
        return goal == 0;
    }
}