class Solution {
    public int jump(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int cur_max_index=nums[0];//当前可达到的最远位置
        int pre_max_index=nums[0];//遍历各个位置的过程中可达到的最远距离
        int min_jump=1;
        for(int i=1;i<nums.length;i++){
            if(i>pre_max_index){//如果i无法再向前，那么在cur_max_index位置之前需要一次跳跃
                pre_max_index=cur_max_index;
                min_jump++;
            }
            if(i+nums[i]>cur_max_index){
                cur_max_index=nums[i]+i;
            }
        }
        return min_jump;
    }
    // public int jump(int[] nums) {

    //     if (nums.length <= 1){
    //         return 0;
    //     }

    //     return nextStep(nums,1,0);
    // }

    // private int nextStep(int[] nums,int step,int index){

    //     if (step == nums.length - 1){
    //         return step;
    //     }

    //     int num = nums[index];

    //     if (nums.length - 1 - index > num){
    //         int max = 0;
    //         int tmp = index;
    //         for (int i = 1; i <=num; i++) {
    //             if (max <= nums[tmp+i] + i){
    //                 max = nums[tmp+i] + i;
    //                 index = tmp+i;
    //             }
    //         }

    //         return nextStep(nums,step+1,index);
    //     }
    //     return step;
    // }
}