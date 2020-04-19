//二分查找超时，换牛顿迭代
class Solution {
public:
    bool isPerfectSquare(int num) {
        if (num < 2) return true;
        long x = num / 2;
        while (x * x > num) x = (x + num / x) >> 1;
        return (x * x == num);
    }
};