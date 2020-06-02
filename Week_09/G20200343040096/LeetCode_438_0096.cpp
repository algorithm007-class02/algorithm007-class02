class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        int s_Len = s.length(), p_Len = p.length();vector<int> countP(26, 0);
        if(p_Len > s_Len) return {};
        vector<int> countS(26, 0);
        vector<int> res;
        for(char c : p){
            countP[c-'a']++;
        }
        for(int i = 0; i < p_Len; ++i){
            countS[s[i] - 'a']++;
        }
        if(countS == countP) res.push_back(0);
        for(int i = 1; i <= s_Len - p_Len; ++i){
            countS[s[i - 1] - 'a']--;
            countS[s[i + p_Len - 1] - 'a']++;
            if(countS == countP) res.push_back(i);
        }
        return res;
    }
};
