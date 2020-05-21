class Solution {
public:
    int myAtoi(string str) {
        int res = 0, sign = 1, i = 0, len = str.length();
        while(i < len && str[i] == ' ') ++i;
        if(str[i] == '-') {
            sign = -1;
            ++i;
        }else if(str[i] == '+'){
            ++i;
        }
        for(; i < len; ++i){
            if(str[i] > '9' || str[i] < '0') break;
            if(sign > 0 && (res > INT_MAX / 10 || (res == INT_MAX / 10 && (str[i] - '0') >= INT_MAX % 10))){
                return INT_MAX;
            }
            if(sign < 0 && (res > INT_MAX / 10 + 1 || (res == INT_MAX / 10 && (str[i] - '0') >= (INT_MAX % 10 + 1)))){
                return INT_MIN;
            }
            res = res * 10 + (str[i] - '0');
        }
        return res * sign;
    }
};
