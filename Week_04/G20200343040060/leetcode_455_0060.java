package module01;

import java.util.Arrays;
import java.util.List;

/**
 * @author JiaYunFei
 * @date 2020/4/1 21:33
 */
public class FindContentChildren_455 {
    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {1, 2};
        int res = findContentChildren(a, b);
        System.out.println(res);
    }


    private static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                //能满足胃口
                res++;
                i++;
                j++;
            } else {
                //不能满足胃口
                j++;
            }
        }
        return res;
    }
}
