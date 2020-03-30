class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> max = new PriorityQueue<>((v1, v2) -> v2 - v1);
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int result[] = new int[n-k+1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (max.size() >= k) {
                max.remove(nums[i-k]);
            }
            max.offer(nums[i]);
            if (i >= k-1) {
                result[index++] = max.peek();
            }
        }
        return result;
    }
}