//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int left = 0,right = height.length-1;
        int result = 0;
        int leftMax = 0,rightMax=0;
        while ( left < right ) {
            if ( height[left] < height[right] ) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                ++left;
            }else  {
                if ((height[right] >= rightMax)) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                --right;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * 数组的每个元素，能达到的最大值为 min(左边最大值，右边最大值) - 当前高度值
 * public int trap(int[] height) {
 *         int result = 0;
 *         int len = height.length;
 *         for ( int i = 0; i < len;i++ ) {
 *             int maxLeft = 0;
 *             int maxRight = 0;
 *             for ( int j = i; j >= 0 ;j--) {
 *                 maxLeft = Math.max(maxLeft,height[j]);
 *             }
 *             for ( int j = i ; j < len; j++ ) {
 *                 maxRight = Math.max(maxRight,height[j]);
 *             }
 *             result += Math.min(maxLeft,maxRight) - height[i];
 *         }
 *         return result;
 *     }
 */

/*
public int trap(int[] height) {
        if ( height == null || height.length == 0 ) return 0;//防止数组越界
        int result = 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        for ( int i = 1; i < len ; i++ ) {
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        rightMax[len-1] = height[len-1];
        for ( int i = len - 2;i >= 0 ;i-- ) {
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }
        for ( int i = 1; i < len-1; i++ ) {
            result += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return result;
    }
 */