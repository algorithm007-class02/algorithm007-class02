//把以前的解法复习一下
//1、暴力法
class Solution {
    public int climbStairs(int n) {
        return climb_Stairs(0,n);
    }
    public int climb_Stairs(int i , int n){
        if(i>n) return 0;
        if(i==n)return 1;
        return climb_Stairs(i+1,n) + climb_Stairs(i+2,n);
    }
}
//2、动态规划
class Solution {
    public int climbStairs(int n) {
        int[] m = new int[n+1];
        m[0] = 1;
        m[1] = 1;
        for(int i = 2; i <=n ; ++i){
            m[i] = m[i-1] + m[i-2];
        }
        return m[n];
    }
}
