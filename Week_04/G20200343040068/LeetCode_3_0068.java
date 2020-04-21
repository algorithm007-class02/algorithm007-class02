class LeetCode_3_0068 {

    //尽可能用小的饼干满足小孩
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int result =0;
        int k =0;
        for(int i =0;i<g.length;i++){

            boolean flag = true;
            for(int j=k;j<s.length;j++){
                if(g[i]<=s[j]){
                    result++;
                    k = j+1;
                    flag= false;
                    break;
                }
            }
            if(flag){
                return  result;
            }
        }
        return result;
    }
}