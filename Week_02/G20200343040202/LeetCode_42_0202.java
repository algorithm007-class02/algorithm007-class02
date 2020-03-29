class Solution {

    // public int trap(int[] height) {
    //     int left = 0, right = height.length - 1;
    //     int lMax = 0, rMax = 0;
    //     int res = 0;
        
    //     while (left < right) {
    //         if (height[left] < height[right]) {
    //             if (lMax > height[left]) {
    //                 res += lMax - height[left];
    //             }
    //             else {
    //                 lMax = height[left];
    //             }
    //             left++;
    //         }
    //         else {
    //             if (rMax > height[right]) {
    //                 res += rMax -height[right];
    //             }
    //             else {
    //                 rMax = height[right];
    //             }
    //             right--;
    //         }
    //     }
    //     return res;
    // }
        
    public int trap(int[] height) {
        if (height.length < 3){
            return 0;
        }
        int result = 0;

        //最大值下标
        int index = maxIndex(height);

        //计算左边雨水量
        result += rainWaterValue(height,index + 1);

        int[] newArr = new int[height.length - index];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = height[height.length - i -1];
        }

        //计算右边雨水量
        result += rainWaterValue(newArr,newArr.length);

        return result;
    }

    private int maxIndex(int[] height){
        int max = 0,index = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > max){
                max = height[i];
                index = i;
            }
        }
        return index;
    }

    private int rainWaterValue(int[] arr,int index){
        int left = 0;

        //是否
        boolean isHasPeak = false;

        int result = 0;

        for (int i = 0; i < index; i++) {

            if (isHasPeak){
                if (arr[i] >= arr[left]){
                    result += calculate(arr,left,i);
                    left = i;
                }

            }else {
                if (arr[i] >= arr[left]){
                    left = i;
                }else {
                    i -= 1;
                }
            }
        }

        return result;
    }

    private int calculate(int[] height,int left,int right){
        int diff = height[left];
        int result = 0;
        for (int i = left + 1; i < right; i++) {
            result += diff - height[i];
        }
        return result;
    }
}