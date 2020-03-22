class Solution {
    public int maxArea(int[] height) {

        int max=0;
        for(int i=0;i<height.length-1;i++){
            for(int j=0;j<height.length;j++){
                int area=(j-i)*Math.min(height[i],height[j]);
                max=Math.max(max,area);
            }
        }
               return max;
    }
}