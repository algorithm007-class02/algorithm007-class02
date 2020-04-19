class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int n = bills.size();
        if (n == 0) return true;
        int ten = 0;
        int five = 0;
        for (int i = 0; i < n; i++) {
            if (bills[i] == 5) five++;
            if (bills[i] == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                    continue;
                }
                return false;
            }
            if (bills[i] == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                    continue;
                }
                if (ten == 0 && five >= 3) {
                    five -= 3;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
};