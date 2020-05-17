class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> ans = vector<int>(num+1,0);
        for(int i=1;i<=num;i++) {
            ans[i] = ans[i/2]+(i&1);
        }
        return ans;
    }
};