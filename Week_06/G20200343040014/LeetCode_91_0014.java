class Solution {
    public int numDecodings(String s) {
        if(s==null||s.charAt(0)=='0'||s.length()==0) return 0;
        if (s.length() == 1) return 1;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        //手动确定dp[1]的值
        char last1 = s.charAt(0);
        char index1 = s.charAt(1);
        if (last1 == '2' && index1 > '6' || last1 > '2'){
            dp[1] = index1=='0'?0:1;
        }else
        {
            dp[1] = index1=='0'?1:2;
        }
        //循环动态规划
        for (int i = 2; i < s.length(); i++) {
            char last = s.charAt(i-1);
            char cur = s.charAt(i);
            if (last == '2' && cur > '6' || last > '2'){ // 当前位和上一位拼接结果 > 26
                if (cur == '0') {
                    break; //连续两个异常结果，结果肯定为0
                }else
                {
                    dp[i] = dp[i -1];
                }
            }else
            {
                if (cur == '0') {
                    if (last == '0') {
                        break; //连续两个异常结果，结果肯定为0
                    }else
                    {
                        dp[i] = dp[i -2];
                    }
                }else{
                    if (last == '0') {
                        dp[i] = dp[i -1];
                    }else{
                        dp[i] = dp[i -1] + dp[i - 2];
                    }
                }                
            }
        }
        return dp[s.length()-1];
    }
}