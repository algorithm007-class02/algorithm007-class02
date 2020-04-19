package level2;

import java.util.*;

@SuppressWarnings("ALL")
public class Solution347 {
    public static void main(String[] args) {
        // TODO 理解其他的解法
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
        System.out.println(topKFrequent(nums, 2).toString());
    }

    //
    public static List<Integer> topKFrequent0(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0)
            return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        List<int[]> elemFreq = new ArrayList<>();
        for (Integer key : map.keySet()) {
            elemFreq.add(new int[] { key, map.get(key) });
        }
        elemFreq.sort((a, b) -> b[1] - a[1]);
        for (int i = 0; i < k; ++i)
            res.add(elemFreq.get(i)[0]);
        return res;
    }

    // 前 K 个高频元素
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList();
        Arrays.sort(nums);
        int distinctLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                distinctLen++;
            }
        }
        int counts[] = new int[distinctLen];
        int order[] = new int[distinctLen];
        int index = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                counts[index] = count;
                order[index] = count;
                nums[index] = nums[i - 1];
                index++;
                count = 1;
            }
        }
        nums[index] = nums[nums.length - 1];
        counts[index] = count;
        order[index] = count;
        Arrays.sort(order);
        int kth = order[distinctLen - k];
        for (int i = 0; i <= index; i++) {
            if (counts[i] >= kth) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    //
    static class Item {
        int count;
        int key;

        public Item(int key, int count) {
            this.count = count;
            this.key = key;
        }
    }

    // 面向对象的解决办法 哈哈
    public static List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> cMap = new HashMap<>();
        for (int c : nums) {
            cMap.put(c, cMap.getOrDefault(c, 0) + 1);
        }
        List<Item> items = new ArrayList<>();
        for (int key : cMap.keySet()) {
            items.add(new Item(key, cMap.get(key)));
        }
        items.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.count - o1.count;
            }
        });
        for (int i = 0; i < k; i++) {
            if (i < items.size()) {
                list.add(items.get(i).key);
            }
        }
        return list;
    }
}
