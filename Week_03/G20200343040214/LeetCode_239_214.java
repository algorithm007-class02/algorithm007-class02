class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 0) {
            return new int[0];
        }
        Deque<Integer> windows = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 清除过期元素
            if (i >= k && windows.peekFirst() <= i - k) {
                windows.pollFirst();
            } // 清除比新插入数小的元素
            while (!windows.isEmpty() && nums[windows.peekLast()] <= nums[i]) {
                windows.pollLast();
            }
            windows.add(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[windows.peekFirst()];
            }
        }
        return result;
    }
}