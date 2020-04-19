class Solution {
public:
    int lemonadeChange(vector<int> bills) {
        int fiveOwned = 0, tenOwned = 0;    // current money we owned
        for (int curBill : bills) {
            if (curBill == 5) fiveOwned++;
            else if (curBill == 10) fiveOwned--, tenOwned++;
            else if (tenOwned > 0) tenOwned--, fiveOwned--;
            else fiveOwned -= 3;
            if (fiveOwned < 0) return false;
        }
        return true;
    }
};