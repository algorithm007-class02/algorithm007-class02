import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.add(1l);
        for(int i = 1; i < n; i++){
            long tmp = minHeap.poll();
            while(!minHeap.isEmpty() && tmp == minHeap.peek()) tmp = minHeap.poll();
            minHeap.add(tmp*2);
            minHeap.add(tmp*3);
            minHeap.add(tmp*5);
        }
        return minHeap.poll().intValue();
    }
}
// @lc code=end

