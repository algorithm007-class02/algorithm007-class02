class Solution {
public:
    int myAtoi(string str) {
        int ans=0;
        int sign=1;
        if (str.size()==0) return ans;
        int i=0;
        while (i<str.size()&&str[i]==' ') ++i;
        if (str[i]=='+'||str[i]=='-') sign=str[i++]=='+'?1:-1;
        while (i<str.size()) {
            if (isdigit(str[i])) {
                int digit=str[i++]-'0';
                if (ans>INT_MAX/10||ans==INT_MAX/10&&INT_MAX%10<digit)
                    return sign==1?INT_MAX:INT_MIN;
                ans = ans*10 +digit;
            } else break;
        }
        return ans*sign;
    }
};