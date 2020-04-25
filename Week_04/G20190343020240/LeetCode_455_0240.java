import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        //为孩子找饼干，遍历饼干，给吃饼干孩子向后移动一位
        int i = 0;//孩子
        for(int j = 0; i < g.length && j < s.length;j++){
            if(g[i] <= s[j])
                i++;
        }
        return i;
    }
}