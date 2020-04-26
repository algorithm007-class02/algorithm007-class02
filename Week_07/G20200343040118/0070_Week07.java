class Solution {
    public int climbStairs(int n) {
        int pre = 1;
        int after = 1;
        int now = 0;
        if(n == 1)
            return pre;
        if(n == 2)
            return pre + after;
        for(int i = 1 ; i < n ; i++){
            now = pre+after;
            pre = after;
            after = now;
        }
        return now;
    }
}