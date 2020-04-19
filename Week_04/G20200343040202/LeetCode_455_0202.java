class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        for (; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}