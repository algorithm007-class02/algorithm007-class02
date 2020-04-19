//暴力
class Solution {
public:
    int countSubstrings(string s) {
        int res = 0, n = s.size();
        for(int i = 0; i < n; ++i){
            for(int j = 0; i-j >= 0 && i+j < n && s[i-j] == s[i+j]; ++j) {
                res++;
            } 
            for(int j = 0; i-1-j >= 0 && i+j < n && s[i-1-j] == s[i+j]; ++j) {
                res++;
            }
        }
        return res;
    }
};