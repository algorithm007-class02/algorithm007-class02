package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class L44TrapWater {

    /**
     * 按行计算
     * 时间复杂度 O(n * m), m为数组中的最大值
     * 空间复杂度 O(1)
     */
    public int trap1(int[] height) {
        assert height != null;
        if (height.length <= 2) {
            return 0;
        }

        int max = 0;
        for (int i : height) {
            if (max < i) {
                max = i;
            }
        }

        int h = 0;
        int ans = 0;
        while (h < max) {
            int tmp = 0;
            boolean addWater = false;
            for (int i = 1; i < height.length; i++) {
                if (height[i] <= h) {
                    if (height[i - 1] > h) {
                        addWater = true;
                    }
                    if (addWater) {
                        tmp++;
                    }
                }

                if (addWater && height[i] > h) {
                    addWater = false;
                    ans += tmp;
                    tmp = 0;
                }
            }
            h++;
        }
        return ans;
    }

    /**
     * 按列计算, 每次循环计算出当前位置左边的最大值和右边最大值
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     */
    public int trap2(int[] height) {
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = 0; j < i; j++) {
                if (height[j] > leftMax) {
                    leftMax = height[j];
                }
            }

            if (height[i] >= leftMax) {
                continue;
            }

            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > rightMax) {
                    rightMax = height[j];
                }
            }

            if (height[i] >= rightMax) {
                continue;
            }

            water += Math.min(leftMax, rightMax) - height[i];
        }

        return water;
    }

    Map<Integer, Integer> leftMaxMap = new HashMap<>();
    Map<Integer, Integer> rightMaxMap = new HashMap<>();

    void genMaxMap(int[] heigth) {
        for (int i = 0; i < heigth.length; i++) {
            Integer leftMax = leftMaxMap.getOrDefault(i - 1, 0);
            if (heigth[i] > leftMax) {
                leftMax = heigth[i];
            }
            leftMaxMap.put(i, leftMax);

            int rightIndex = heigth.length - i - 1;
            Integer rightMax = rightMaxMap.getOrDefault(rightIndex + 1, 0);
            if (heigth[rightIndex] > rightMax) {
                rightMax = heigth[rightIndex];
            }
            rightMaxMap.put(rightIndex, rightMax);
        }
    }

    /**
     * 按列计算: 将当前位置左边的最大值和右边最大值缓冲到一个hashmap中
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int water = 0;
        genMaxMap(height);

        for (int i = 0; i < height.length; i++) {
            int leftMax = leftMaxMap.get(i);
            if (height[i] >= leftMax) {
                continue;
            }

            int rightMax = rightMaxMap.get(i);
            if (height[i] >= rightMax) {
                continue;
            }

            water += Math.min(leftMax, rightMax) - height[i];
        }
        return water;
    }

    /**
     * 按列计算: 将当前位置左边的最大值和右边最大值缓冲到一个array中, 将hashmap简化为一个array
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int trap4(int[] height) {
        int water = 0;

        int[] leftMaxArray = new int[height.length];
        int[] rightMaxArray = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            leftMaxArray[i] = Math.max((i - 1) >= 0 ? leftMaxArray[i - 1] : 0, height[i]);;

            int rightIndex = height.length - i - 1;
            rightMaxArray[rightIndex] = Math.max(
                    (rightIndex + 1 <= height.length - 1) ? rightMaxArray[rightIndex + 1] : 0, height[rightIndex]);
        }

        for (int i = 0; i < height.length; i++) {
            int leftMax = leftMaxArray[i];
            int rightMax = rightMaxArray[i];

            water += Math.min(leftMax, rightMax) - height[i];
        }
        return water;
    }

    /**
     * 按列计算: 将当前位置左边的最大值和右边最大值缓冲到一个array中, 将hashmap简化为一个array
     * 优化空间复杂度: 去掉leftMaxArray
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int trap5(int[] height) {
        int water = 0;

        int[] rightMaxArray = new int[height.length];

        int rightMax = -1;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            rightMaxArray[i] = rightMax;
        }

        int leftMax = -1;
        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i]);;
            water += Math.min(leftMax, rightMaxArray[i]) - height[i];
        }
        return water;
    }

    /**
     * 优化空间复杂度
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int trap(int[] height) {
        int water = 0;

        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                water += (maxLeft - height[left]);
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                water += (maxRight - height[right]);
                right--;
            }
        }

        return water;

        /* 逻辑：
         由于 每一步增加的水量为：Math.min(leftMax[i], rightMaxArray[i]) - height[i];
          当 leftMax < rightMax时，水的容量由lefMax确定。否则由rightMax确定

         当i=0，如果height[0] < height[height.length - 1]
          leftMax[0] = height[0]
          rightMax[0] = ?
          rightMax[height.length - 1] = height[height.length - 1]
          这时: rightMax[0] >=
                      rightMax[height.length - 1] = height[height.length - 1]
                      > height[0] = leftMax[0]
                  即： rightMax[0] > leftMax[0]
          所以 通过算leftMax[0] 计算水量即可
          然后 left递增为1

         如果 height[1] < height[height.length - 1]
           leftMax[1] = max(height[0], heigth[1])
           rightMax[1] = ?
           rightMax[height.length - 1] = height[height.length - 1]
          这时: rightMax[1] >=
                      rightMax[height.length - 1] = height[height.length - 1]
                      > max (height[0], height[1]) = leftMax[1]
                  即： rightMax[1] > leftMax[1]
          所以 通过算leftMax[1] 计算水量即可
          然后 left递增为2
          数学归纳法。。。

         如果 height[1] >= height[height.length - 1]
         rightMax[height.length - 1] = height[height.length - 1]
           <= height[1] <= leftMax[1] <= leftMax[height.length - 1]

           即：rightMax[height.length - 1] <= leftMax[height.length - 1]

          所以 通过算rightMax[height.length - 1] 计算水量即可
          然后 right递减为heigth.length -2

          数学归纳法。。。
         */
    }

}
