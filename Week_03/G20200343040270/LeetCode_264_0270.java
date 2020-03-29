//编写一个程序，找出第 n 个丑数。
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。
//
// 示例:
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
//
//
// 1 是丑数。
// n 不超过1690。
//
// Related Topics 堆 数学 动态规划

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 解法一： 堆
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> smallHeap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        long[] base = {2, 3, 5};
        for (long i : base) {
            smallHeap.offer(i);
            set.add(i);
        }
        long res = 1;
        for (int i = 1; i < n; i++) {
            res = smallHeap.poll();
            for (int j = 0; j < 3; j++) {
                long val = res * base[j];
                if (!set.contains(val)) {
                    set.add(val);
                    smallHeap.offer(val);
                }
            }
        }
        return (int)res;
    }

    /**
     * 解法一： 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> smallHeap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        long[] base = {2, 3, 5};
        for (long i : base) {
            smallHeap.offer(i);
            set.add(i);
        }
        long res = 1;
        for (int i = 1; i < n; i++) {
            res = smallHeap.poll();
            for (int j = 0; j < 3; j++) {
                long val = res * base[j];
                if (!set.contains(val)) {
                    set.add(val);
                    smallHeap.offer(val);
                }
            }
        }
        return (int)res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
