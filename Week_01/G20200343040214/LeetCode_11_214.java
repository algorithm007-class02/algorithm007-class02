public class Solution11 {
    public static void main(String[] args) {
        System.out.println(maxArea2(new int[]{1, 8, 6, 2,5,4,8,3,7}));
    }
    // 暴力法 循环
    public static int maxArea1(int[] height){
        // force loop
        int len = height.length;
        int maxArea = 0;
        for(int i=0; i< len-1; i++){
            for(int j=i+1; j<len; j++){
                int area = Math.min(height[i], height[j]) * (j-i);
                if (maxArea < area){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
    // 双指针
    public static int maxArea2(int[] height){
        // double pointer
        int left = 0;
        int right = height.length - 1;
        int maxArea =0;
        // who is small move whop
        while (left <= right){
            int area = Math.min(height[left], height[right]) * (right-left);
            if (maxArea <= area) maxArea = area;
            if (height[left] <= height[right]){
                left += 1;
            } else {
                right -= 1;
            }
        }
        return maxArea;
    }
}
