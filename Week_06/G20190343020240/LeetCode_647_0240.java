class Solution {
    /**
     * 暴力求解，重点在于i + j - 1
     * @param s
     * @return
     */
    public int countSubstrings1(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for(int i = 2;i <= s.length();i++){
            for(int j = 0;i + j - 1 < s.length();j++){
                if(helper(chars,j,j + i - 1))
                    res++;
            }
        }
        return res + s.length();
    }
    private boolean helper(char[] chars,int start,int end){
        for(int i = start,j = end;j > i;i++,j--){
            if(chars[i] != chars[j])
                return false;
        }
        return true;
    }

    public int countSubstrings2(String s) {
        //s=abc;
        //boolean数组下标从0,0到3,3，第二个数字下标大于等于第一个，构成倒三角
        char[] chars = s.toCharArray();
        int res = 0;
        boolean[][] flag = new boolean[chars.length][chars.length];

        for(int i = 0;i < chars.length;i++){
            for(int j = i;j >= 0;j--){
                //在三个数以下的时候，只需判断一次，三个数以上的时候，会判断去除头尾后的字符串是否为回文字符串
                if(chars[i] == chars[j] && (i - j < 2 || flag[j + 1][i - 1])){
                    flag[j][i] = true;
                    res++;
                }
            }
        }
        return res;
    }

    int res = 0;

    /**
     * 参考第二个方法中二维数组上三角
     * @param s
     * @return
     */
    public int countSubstrings3(String s) {
        //s = abc;
        if(null == s || s.length() == 0) return 0;
        for(int i = 0;i < s.length();i++){
            helper(s,i,i);// 0,0 1,1 2,2 0,2
            helper(s,i,i + 1);// 0,1 1,2
        }
        return res;
    }
    private void helper(String s,int left,int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            res++;
            left--;
            right++;
        }
    }
}