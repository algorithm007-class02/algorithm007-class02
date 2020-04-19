/*̰�ķ�
ʱ�临�Ӷȣ�O(N)
�ռ临�Ӷȣ�O(1)*/
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