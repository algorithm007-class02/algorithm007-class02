public class LeetCode_43_0222 {

    /**
     * 解法1：暴力法，遍历所有的列，向两边扩展求出两边各自最大的边进行比较，
     * 较小者为高，算出当前位置的水位高度
     * 时间复杂度为O(n^2) 空间复杂大为O(1)
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = 0;
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            int minHeight = Math.min(leftMax, rightMax);
            if (minHeight > height[i]) {
                sum = sum + minHeight - height[i];
            }
        }
        return sum;
    }

    /**
     * 解法2： 解法的优化，将某列左右两边的最大值 放入到新的数组中，遍历的时候不需要每次重新遍历
     * 时间复杂度为O(n),空间复杂度为O(n)
     * @param height
     * @return
     */
    public int trapRe(int[] height) {
        int sum = 0;
        int[] rightMax = new int[height.length];
        int[] leftMax = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(rightMax[i], leftMax[i]);
            if (min > height[i]) {
                sum = sum + min - height[i];
            }
        }
        return sum;
    }

    /**
     * 解法3：对解法2进行进一步优化，发现左边最大的不需要保存，在最后一步遍历中，计算左边最大值就可以
     * 时间复杂度为O(n),空间复杂度为O(n)
     * @param height
     * @return
     */
    public int trapRe3(int[] height) {
        int sum = 0;
        int maxLeft = 0;
        int[] rightMax = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft = Math.max(maxLeft, height[i - 1]);
            int min = Math.min(rightMax[i], maxLeft);
            if (min > height[i]) {
                sum = sum + min - height[i];
            }
        }
        return sum;
    }

    /**
     * 解法4： 在解法3的基础上优化，消除rightMax数组可以同时在两端求解最大值，发现我们可以从两边夹逼的思路进行求解
     * 当左边的leftax 小于右边的rightMax 时，可以确定添加水一定是根据leftMax 和当前left位置比较进行求解
     * 否则添加水一定是根据rightMax 和当前right位置比较进行求解
     * 时间复杂度为O(n),空间复杂度为O(1)
     * @param height
     * @return
     */
    public int trapRe4(int[] height) {
        int sum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 1;
        int right = height.length - 2;
        while(right >= left) {
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                int min = maxLeft;
                if (min > height[left]) {
                    sum = sum + min - height[left];
                }
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right + 1]);
                int min = maxRight;
                if (min > height[right]) {
                    sum = sum + min - height[right];
                }
                right--;
            }
        }
        return sum;
    }

    /**
     * 解法5：用栈的思想去解决，可以看作是括号匹配的问题，两个柱子当作是匹配的括号
     * 当前位置的高度大于栈顶位置的高度时，取出栈定位置，计算两者直接的存水量
     * 时间复杂度为O(n),空间复杂度为O(n)即栈大小
     * @param height
     * @return
     */
    public int trapRe5(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack();
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int distince = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distince * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }


}