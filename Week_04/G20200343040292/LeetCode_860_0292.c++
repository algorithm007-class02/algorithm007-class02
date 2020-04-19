/*̰�ķ�
ʱ�临�Ӷȣ�O(N)
�ռ临�Ӷȣ�O(1)*/
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