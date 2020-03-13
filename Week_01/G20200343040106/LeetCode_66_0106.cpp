class Solution {
public:
    vector<int> plusOne(vector<int>& digits){
        for(int i=(int)digits.size()-1;i>=0;i--){
            digits[i]+=1;
            digits[i]%=10;
            if(digits[i]!=0){
                return digits;
            }
        }
        digits.push_back(0);
        digits[0] = 1;
        return digits;
    }
};
