class LeetCode_69_0236 {
    public int mySqrt(int x) {
        if(x == 0  || x == 1) return x;

        long left = 1;
        long right = x ;
        long mid = 1;

        while(left <= right){
         mid = left +  (right - left) /2 ;
            if(mid * mid > x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return (int)right;
    }
}