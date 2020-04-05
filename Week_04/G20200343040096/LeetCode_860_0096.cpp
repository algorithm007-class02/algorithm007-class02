class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        vector<int> res (2, 0);
        for(auto bill : bills){
            if(bill == 5) ++res[0];
            else if(bill == 10){
                if(res[0] < 1) return false;
                --res[0];
                ++res[1];
            }else{
                if (res[1] >= 1 && res[0] >= 1){
                    --res[1];
                    --res[0];
                }else if(res[0] >= 3){
                    res[0] -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
};
