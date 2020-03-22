import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (49.20%)
 * Likes:    935
 * Dislikes: 0
 * Total Accepted:    63.3K
 * Total Submissions: 128.3K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */

// @lc code=start
class Solution {
    Deque<Integer> queue = new ArrayDeque<>();
    public int trap(int[] height) {
        int max = countInc(height);
        int remainSize = queue.size();
        queue.clear();
        int[] remaminData = new int[remainSize];
        for (int i = 0; i < remainSize; i++) {
            remaminData[i] = height[height.length - 1 - i];
        }
        max += countInc(remaminData);
        return max;
    }

    private int countInc(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (queue.isEmpty() || height[i] < queue.peekFirst()) {
                queue.addLast(height[i]);
            } else {
                int left = queue.removeFirst();
                while (!queue.isEmpty()) {
                    max += left - queue.removeFirst();
                }
                queue.addLast(height[i]);
            }
        }
        return max;
    }
}
// @lc code=end

