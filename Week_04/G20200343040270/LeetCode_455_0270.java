class Solution {

    /**
     * 贪心算法
     * 时间复杂度：O(nlogn + klogk) + O(min(n,k)) --> O(nlogn)
     * 时间复杂度：O(1)
     */
    public int findContentChildren(int[] g, int[] s) {
        int sum = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for(int i = 0; i < g.length; ++i){
            while (j < s.length){
                if(g[i] <= s[j++]){
                    ++sum;
                    break;
                }
            }
            if(j == s.length) break;
        }
        return sum;
    }
}