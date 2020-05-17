class Solution {
public:
    static bool mysort(vector<int> &v1,vector<int> &v2){
        return v1[0]<v2[0];
    }
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ans;
        int n = intervals.size();
        if(n<=1){
            return intervals;
        }
        std::sort(intervals.begin(),intervals.end(),mysort);
        int startRange = intervals[0][0];
        int endRange = intervals[0][1];

        for(int i=1;i<n;i++){
            if(endRange>=intervals[i][0]){
                endRange = max(endRange,intervals[i][1]);
            }else{
                ans.push_back(vector<int>({startRange,endRange}));
                startRange = intervals[i][0];
                endRange = intervals[i][1];
            }
        }
        ans.push_back(vector<int>({startRange,endRange}));
        return ans;
    }
};