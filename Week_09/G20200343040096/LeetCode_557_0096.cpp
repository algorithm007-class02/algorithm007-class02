class Solution {
public:
    void helper(string&s, int i, int j){
        while(i < j){
            char c = s[i];
            s[i++] = s[j];
            s[j--] = c;
        }
    }

    string reverseWords(string s) {
        int len = s.length(), i = 0, j = 0;
        while(i < len){
            j = i;
            while(j + 1 <= len - 1 && s[j + 1] != ' '){
                ++j;
            }
            helper(s, i, j);
            i = j + 2;
        }
        return s;
    }
};
