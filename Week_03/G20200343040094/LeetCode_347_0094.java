import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> (a.getValue() - b.getValue()));
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            minHeap.add(entry);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while(res.size() < k) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}
// @lc code=end

