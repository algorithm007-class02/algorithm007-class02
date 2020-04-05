package level1;

import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i += 1;
            }
            j += 1;
        }
        return i;
    }

    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int gIndex = g.length - 1;
        int sIndex = s.length - 1;
        while (sIndex >= 0 && gIndex >= 0) {
            if (s[sIndex] >= g[gIndex]) {
                sIndex--;
                gIndex--;
                count++;
            } else {
                gIndex--;
            }
        }
        return count;
    }
}
