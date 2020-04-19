class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        int res = 0;
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        for (int i = 0, j = 0; i < g.size(); i++, j++) {
            while (j < s.size() && s[j] < g[i]) j++;
            if (j >= s.size()) return res;
            res++;
        }
        return res;
    }
};