class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        vector<vector<int>> res;
        for(int i = 0; i < intervals.size(); ++i){
            int left= intervals[i][0], right = intervals[i][1];
            if(res.empty() || left > res.back()[1]){
                res.push_back({left, right});
            }else if(right > res.back()[1]){
                res.back()[1] = right;
            }
        }
        return res;
    }
};
