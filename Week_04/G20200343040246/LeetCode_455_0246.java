package Week_04.G20200343040246;

import java.util.Arrays;

class LeetCode_455_0246 {
    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        System.out.println(new LeetCode_455_0246().findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for(int j = 0; i < g.length && j < s.length; j++) {
            if(g[i]<=s[j]) i++;
        }
        return i;
    }
}