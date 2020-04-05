class Solution {
        // 先排序
        // 饼干只能分给一个孩子，一个孩子也只能吃一块饼干，所以同时遍历饼干和孩子，直到有一个用完为止。
        // 如果能满足，那么继续下一个孩子and饼干；
        // 如果不能满足，那么继续从剩下的饼干里找能满足条件的；
        // 如果剩下的饼干里面都不能满足，那么后面的孩子也不用看了，胃口都比当前的大。
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int child = 0;
        int cookie = 0;
        while (child < g.length && cookie < s.length){
            if (g[child]<= s[cookie]){
                res++;
                child ++;
                cookie ++;
            }else
            {
                cookie ++;
            }
        }
        return res;
    }
}