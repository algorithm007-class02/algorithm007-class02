class Solution {
public:
    string reverseWords(string s) {
        reverse(s.begin(), s.end());
        int idx = 0, len = s.length();
        for(int start = 0; start < len; ++start){
            if(s[start] != ' '){
                if(idx != 0) s[idx++] = ' ';
                int end = start;
                while(end < len && s[end] != ' ') s[idx++] = s[end++];
                reverse(s.begin() + idx - (end - start), s.begin() + idx);
                start = end;
            }
        }
        s.erase(s.begin() + idx, s.end());
        return s;
    }
};
