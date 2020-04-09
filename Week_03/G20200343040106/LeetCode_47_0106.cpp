#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
    vector<vector<int>> ans;
    int n;
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        n = nums.size();
        vector<int> temp;
        vector<bool> isvisited = vector<bool>(n,false);
        sort(nums.begin(),nums.end());                            //排序   这样可以处理[3,3,0,3]这种特殊情况
        traceBack(nums,temp,isvisited);
        return ans;
    }

    void traceBack(vector<int>& nums,vector<int> &temp,vector<bool>& isvisited){
        if(temp.size()==nums.size()){
            ans.push_back(temp);
            return ;
        }
        for(int i=0;i<n;i++){
            if(i!=n-1&&nums[i]==nums[i+1]&&!isvisited[i+1])     //剪枝，去重
                continue;
            if(!isvisited[i]){
                temp.push_back(nums[i]);
                isvisited[i] = true;
                traceBack(nums,temp,isvisited);
                temp.pop_back();
                isvisited[i] = false;
            }

        }
    }
};