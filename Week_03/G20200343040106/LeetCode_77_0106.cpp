class Solution {
public:
    vector<vector<int>> ans;
    vector<vector<int>> combine(int n, int k) {
        vector<int> cur = vector<int>();
        traceBack(cur,0,n,k);
        return ans;
    }

    void traceBack(vector<int>& curstate,int start,int n,int k){
        if(curstate.size()==k){
            ans.push_back(curstate);
            return ;
        }
        for(int i=start+1;i<=n;i++){
            curstate.push_back(i);
            traceBack(curstate,i,n,k);
            curstate.pop_back();
        }
    }
};
