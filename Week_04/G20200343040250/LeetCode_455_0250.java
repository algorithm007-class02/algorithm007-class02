class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) return 0;
        // 贪心算法，优先满足胃口最小的孩子
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0, sIndex = 0, total = 0; 
        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex]) {
                total++;
                gIndex++;
            }
            sIndex++;
        }
        return total;
    }
}