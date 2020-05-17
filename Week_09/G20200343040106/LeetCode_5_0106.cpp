class Solution {
public:
    int maxLen;
    int l;
    string longestPalindrome(string s) {
        maxLen = 0;
        int len = s.size();
        if(len<2) return s;
        for(int i=0;i<len-1;i++) {
            helper(s,i,i);
            helper(s,i,i+1);
        }
        return s.substr(l,maxLen);
    }

    void helper(string &s,int lo,int hi) {
        if(s[lo]!=s[hi]) return ;
        while(lo>=0&&hi<s.size()&&s[lo]==s[hi]) {
            lo--;
            hi++;
        }
        if(maxLen < hi-lo-1) {
            maxLen = hi-lo-1;
            l = lo+1;
        }
        return ;

    }

};