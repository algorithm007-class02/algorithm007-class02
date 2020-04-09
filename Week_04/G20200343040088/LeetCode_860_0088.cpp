class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        // 每次都是最有解

        int five = 0; 
        int ten = 0;

        for (auto bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                // bill 为 20
                if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                } else if (five > 3) {
                    five = five - 3;
                } else {
                    return false;
                }
            }
        }

        return true;

    }
};