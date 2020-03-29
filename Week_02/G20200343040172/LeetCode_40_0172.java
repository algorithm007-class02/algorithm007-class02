package week02.g20200343040172;

import java.util.*;

/**
 * https://leetcode-cn.com/submissions/detail/55681573/
 * LeetCode-40 最小的K个数
 */
public class LeetCode_40_0172 {


    /**
     * 排序以后取前K个数
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers_1(int[] arr, int k) {
        if (arr == null || k > arr.length || arr.length == 0) {
            return new int[0];
        }
        //排序以后取前K个数
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    /**
     * 使用PriorityQueue
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers_2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }

    /**
     * 使用TreeMap
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers_3(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // TreeMap的key是数字, value是该数字的个数。
        // cnt表示当前map总共存了多少个数字。
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num: arr) {
            // 1. 遍历数组，若当前map中的数字个数小于k，则map中当前数字对应个数+1
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            // 2. 否则，取出map中最大的Key（即最大的数字), 判断当前数字与map中最大数字的大小关系：
            //    若当前数字比map中最大的数字还大，就直接忽略；
            //    若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数-1。
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
        }

        // 最后返回map中的元素
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int freq = entry.getValue();
            while (freq> 0) {
                res[idx++] = entry.getKey();
                freq--;
            }
        }
        return res;
    }

    /**
     * 根据题目给的限制，可以直接基数排序
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i] <= 10000
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers_4(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 统计每个数字出现的次数
        int[] counter = new int[10001];
        for (int num: arr) {
            counter[num]++;
        }
        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }
}

/**
 * 方法五：使用快排思想
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int start, int end, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        //TODO hi=nums.length-1
        int j = partition(nums, start, end);
        //TODO k=K-1
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums, start, j - 1, k) : quickSearch(nums, j + 1, end, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。

    private int partition(int[] nums, int start, int end) {
        int v = nums[start];
        int i = start, j = end + 1;
        while (true) {
            while (++i <= end && nums[i] < v) {
                ;
            }
            while (--j >= start && nums[j] > v) {
                ;
            }
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[start] = nums[j];
        nums[j] = v;
        return j;
    }
}
