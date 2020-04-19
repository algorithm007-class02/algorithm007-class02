//binary serach

class Solution {
public:
    bool isPerfectSquare(int num) {
        if(num==1||num==0)
            return true;
        
        int left = 1;
        int right = num;
        while(left<=right){
            long mid = left+(right-left)/2;
            if(mid*mid>num){
                right = mid-1;
            }else if(mid*mid<num){
                left = mid+1;
            }else{
                return true;
            }
        }
        return false;
            
    }
};


class Solution {
public:
    bool isPerfectSquare(int num) {
        if(num<2)
            return true;
        long x = num/2;
        while(x*x>num){
            x = (x+num/x)/2;
        }
        return x*x==num;
    }
};