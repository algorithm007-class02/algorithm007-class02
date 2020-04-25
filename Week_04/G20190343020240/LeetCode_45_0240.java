class Solution {
    /**
     * 算法超时
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        //循环找，贪心算法，
        //从第一位开始找能跳到目标位置的下标
        //如果不为0，则进行二次查找到跳到该位置的下标
        //直至下标为0
        if(nums.length == 0) return 0;
        int goal = nums.length - 1;
        int steps = 0;
        while(goal > 0){
            for(int i = 0;i < nums.length - 2;i++){
                if(nums[i] >= goal - i){
                    goal = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public int jump1(int[] nums){
        int step = 0;
        //边界
        int index = 0;
        int maxSize = 0;
        for(int i = 0;i < nums.length - 1;i++){
            maxSize = Math.max(maxSize,nums[i] + i);
            if(i == index){
                step++;
                //下一次边界位于当前节点最远距离
                index = maxSize;
            }
        }
        return step;
    }
}