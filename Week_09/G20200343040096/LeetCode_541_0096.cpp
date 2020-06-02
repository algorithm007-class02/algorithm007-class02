class Solution {
public:
    void helper(string& s, int i, int j){
        while(i < j){
            char t = s[i];
            s[i++] = s[j];
            s[j--] = t;
        }
    }

    string reverseStr(string s, int k) {
        int count = 0, i = 0, j = 0, len = s.length();
        while(i < len){
            j = std::min(i + k - 1 , len - 1);
            helper(s, i, j);
            i = j + k + 1;
        }
        return s;
    }
};
