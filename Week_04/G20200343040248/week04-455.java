class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int count=0;
        while(i < g.length && count < s.length){
            if(g[i] <= s[count]){
                i++;
            }count++;
        }
        return i;
    }
}

//思路：先排序，然后双指针指向小孩儿和饼干，如果小孩能吃到饼干，小孩数+1，否则跳过，只增加饼干size继续匹配。