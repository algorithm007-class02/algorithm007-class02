/*贪心法
时间复杂度：O(N)
空间复杂度：O(1)*/
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());

        int j = 0;
        for (int i = 0; i < s.size() && j < g.size();) {
            if (s[i++] >= g[j]) {
                j++;
            }
        }
        return j;
    }
};