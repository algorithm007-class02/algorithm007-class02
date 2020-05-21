class Solution {
public:
    string reverseOnlyLetters(string S) {
        int l = 0, r = S.length() - 1;
        while(l < r){
            while(l < r && (S[l] > 'z' || S[l] < 'A' || (S[l] > 'Z' && S[l] < 'a'))){
                ++l;
            }
            while(l < r && (S[r] > 'z' || S[r] < 'A' || (S[r] > 'Z' && S[r] < 'a'))){
                --r;
            }
            char t = S[l];
            S[l++] = S[r];
            S[r--] = t;
        }
        return S;
    }
};
