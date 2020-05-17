class Solution {
public:
    string reverseStr(string s, int k) {
        int n = s.size();
        int start = 0;
        while(start<s.size()) {
            int end = min(n-1,start+k-1);
            reverse(s,start,end);
            start += 2*k;

        }
        return s;
    }
    void reverse(string &s,int start,int end) {
        while(start<end) {
            swap(s[start++],s[end--]);
        }
        return ;
    }
};