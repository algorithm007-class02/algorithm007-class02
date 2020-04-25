/*贪心法
时间复杂度：O(N)
空间复杂度：O(1)*/
class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int five = 0, ten = 0;
        for (auto bill : bills) {
            if (bill == 5)
                five++;
            else if (bill == 10)  {
                if (five == 0) 
                    return false;
                five--;
                   \ten++;
            }
            else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                }
                else if (five >= 3)
                    five -= 3;
                else
                    return false;
            }
        }
        return true;
    }
};