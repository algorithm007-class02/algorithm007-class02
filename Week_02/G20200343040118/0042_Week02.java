class Solution {
    public int trap(int[] height) {
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        for(int i = 1 ; i < height.length ; i++){
            max_right[i] =Math.max(max_right[i-1],height[i-1]); 
        }
        for(int i = height.length-2 ; i >= 0 ; i--){
            max_left[i] = Math.max(max_left[i+1],height[i+1]);
        }
        int temp = 0;
        int sum = 0;
        for(int i = 1 ; i < height.length - 1 ; ++i){
            temp = Math.min(max_right[i],max_left[i]);
            if(temp > height[i])
                sum+=temp-height[i];
        }
        return sum;
    }
}