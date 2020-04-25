class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        if (s.empty()||g.empty()) return 0;
        sort(g.begin(),g.end());
        sort(s.begin(),s.end());
        int count=0;
        int i=0,j=0;
        for (;i<g.size();++i){
            if (g[i]>s[s.size()-1]) break;
            for (;j<s.size();++j){
                if (s[j]>=g[i]){
                    count++;
                    j++;
                    break;
                }
            }
        }
        return count;
    }
};