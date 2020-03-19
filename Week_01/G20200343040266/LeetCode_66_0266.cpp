class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int temp=1;
        for(int i=digits.size()-1;i>=0;i--){
            int sum=temp+digits[i];
            digits[i]=sum%10;
            temp=sum/10;
        }
        if(temp>0){
            digits.insert(digits.begin(),1);
        }
        return digits;
    }
};