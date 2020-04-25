class Solution {
    /* trapping-rain-water */

    /**
     * 暴力破解
     * 时间 O(n^2)
     * 空间 O(1)
     */
    public int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            for (int j = i; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            System.out.println("maxLeft = " + maxLeft + " maxRight = " + maxRight);

            ans += Math.min(maxLeft, maxRight) - height[i];
        }

        return ans;
    }

    /**
     * 动态规划
     *
     * @param height
     * @return
     */
    public int trap_1(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int[] maxLeftList = new int[height.length];
        int[] maxRightList = new int[height.length];


        maxLeftList[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeftList[i] = Math.max(height[i], maxLeftList[i - 1]);
        }

        maxRightList[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRightList[i] = Math.max(height[i], maxRightList[i + 1]);
        }

        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.min(maxLeftList[i], maxRightList[i]) - height[i];
        }

        return ans;
    }

    /**
     * 双指针优化动态规划空间
     * @param height
     * @return
     */
    public int trap_2(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    /**
     * 堆栈解法
     * @param height
     * @return
     */
    public int trap_3(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }
}