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
    /*public int trap(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length - 1; ++i) {
            for (int j = i + 1; j < a.length; ++j) {
                int area = (j - i) * Math.min(a[i],a[j]);
                max = Math.max(max,area);
            }
        }
        return max;
    }*/
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1;
        i<j ;){
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)






















