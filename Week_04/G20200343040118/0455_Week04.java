class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int count = 0;
        while(i<g.length && j < s.length){
            if(s[j]>=g[i]){
                j++;i++;count++;
            }else{
                j++;
            }
        }
        return count;
    }
}