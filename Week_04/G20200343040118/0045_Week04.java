class Solution {
    public int jump(int[] nums) {
        int newPoint = 0;
        int end = 0;
        int step = 0;
        for(int i = 0 ; i < nums.length ; i++){
            newPoint = Math.max(newPoint,nums[i]+i);
            if(i == end && i != nums.length-1){
                end = newPoint;
                step++;
            }
        }
        return step;
    }

}