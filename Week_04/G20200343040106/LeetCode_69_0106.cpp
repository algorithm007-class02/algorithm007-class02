// x的平方根
// 思路1：二分法
// 思路2：牛迭


class Solution {
public:
    int mySqrt(int x) {
        if(x==0||x==1){
            return x;
        }
        int left = 1;
        int right = x;
        while(left<=right){
            long mid = left+(right-left)/2;
            if(mid*mid>x){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return (int)right;
    }
};

//牛迭
class Solution {
public:
    int mySqrt(int x) {
        
        double cur = 1;
        while(abs(cur*cur-x)>1e-6){
            cur = (cur+x/cur)/2;
        }
        return (int)cur;
    }
};


