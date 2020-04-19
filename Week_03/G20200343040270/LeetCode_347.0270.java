//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
// 示例 1:
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//
// 示例 2:
//
// 输入: nums = [1], k = 1
//输出: [1]
//
// 说明：
//
//
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
class Solution {

    /**
     * 解法一：大顶堆
     * 时间复杂度：O(nlogk)
     * 时间复杂度：O(n)
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i,0) + 1);
        PriorityQueue<Pair<Integer,Integer>> bigHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() -o1.getValue());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            bigHeap.add(new Pair<>(entry.getKey(),entry.getValue()));
        }
        while (res.size() < k){
            res.add(bigHeap.poll().getKey());
        }
        return res;
    }

    /**
     * 解法一：小顶堆
     * 时间复杂度：O(nlogk)
     * 时间复杂度：O(k)
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i,0) + 1);
        PriorityQueue<Pair<Integer,Integer>> smallHeap = new PriorityQueue<>((o1, o2) -> o1.getValue() -o2.getValue());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(smallHeap.size() < k){
                smallHeap.add(new Pair<>(entry.getKey(),entry.getValue()));
            }else {
                if(smallHeap.peek().getValue() < entry.getValue()){
                    smallHeap.poll();
                    smallHeap.add(new Pair<>(entry.getKey(),entry.getValue()));
                }
            }
        }
        while (!smallHeap.isEmpty()){
            res.add(smallHeap.poll().getKey());
        }
        return res;
    }
}