class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        int ans = 0;
        int i =0;
        int j =0;
        sort(g.begin(),g.end());
        sort(s.begin(),s.end());
        while(i<g.size()&&j<s.size()){
            if(s[j]>=g[i]){
                ans++;
                i++;
            }
            j++;
        }
        return ans;
    }
};