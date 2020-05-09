泰波那契序列 Tn 定义如下： 

 T0 = 0, T1 = 1, T2 = 1, 且在 n = 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2 

 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。 

 

 示例 1： 

 输入：n = 4
输出：4
解释：
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
 

 示例 2： 

 输入：n = 25
输出：1389537
 

 

 提示： 

 
 0 = n = 37 
 答案保证是一个 32 位整数，即 answer = 2^31 - 1。 
 
 Related Topics 递归


leetcode submit region begin(Prohibit modification and deletion)
class Solution1137 {
    public int tribonacci(int n){
        int[] ans = new int[38];
        ans[0]=0;
        ans[1]=1;
        ans[2]=1;
        for (int i=3; i38; i++){
            ans[i]=ans[i-1]+ans[i-2]+ans[i-3];
        }
        return ans[n];
    }
    
      耗时0ms（100%），使用内存36.4M（14%）
}
leetcode submit region end(Prohibit modification and deletion)

递归法超出时间限制
    public int tribonacci(int n) {
        if (n==0) {return 0;}
        else if (n==1  n==2) {return 1;}
        else {
            return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
        }
    }
