class Solution {
    
    public void rotate(int[] nums, int k) {
        // 减掉多余的右旋次数
        /** 我的SB做法
        while(k >= nums.length && k >= 0) {
            k = k-nums.length;
        }*/
        // 题解余数大法好
        k %= nums.length;
        //右旋算法
        if(k != 0) {
            //所有数组元素逆置
            this.reverse(nums, 0, nums.length-1);
            //前k个元素逆置
            this.reverse(nums, 0, k-1);
            //余下元素逆置
            this.reverse(nums, k,nums.length-1);
        }

    }
    private void reverse(int[] nums,int start,int end){
        int i,j;
        int temp;
        for(i = start, j = end; i < j; ++i, --j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
    
}