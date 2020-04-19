//任意一个丑数都是由小于它的某一个丑数*2，*3或者*5得到的
/*
A：{1*2，2*2，3*2，4*2，5*2，6*2，8*2，10*2......}
B：{1*3，2*3，3*3，4*3，5*3，6*3，8*3，10*3......}
C：{1*5，2*5，3*5，4*5，5*5，6*5，8*5，10*5......}
所有丑数的排列，必定就是上面ABC3个数组的合并结果然后去重得到的，所以只需合并这三个有序数组的无重复元素即可！
*/
class Solution {
public:
    int nthUglyNumber(int n) {
        int res = 0;
        if (n == 0) return res;
        vector<int> ugly(n, 0);
        ugly[0] = 1;
        int i,j,k = 0;
        for (int index = 1; index < n; index++) {
            int tmp = min(ugly[i] * 2, min(ugly[j] * 3, ugly[k] * 5));
            if (tmp == ugly[i] * 2) i++;
            if (tmp == ugly[j] * 3) j++;
            if (tmp == ugly[k] * 5) k++;
            ugly[index] = tmp;
        }
        res = ugly[n - 1];
        return res;
    }
};