#include<vector>
using namespace std;
class Solution {
public:
    vector<vector<int>> ans;
    vector<vector<int>> permute(vector<int>& nums) {
        vector<bool> chosed = vector<bool>(nums.size(),false);
        vector<int> temp = vector<int>();
        trace(nums,chosed,temp);
        return ans;
    }

    void trace(vector<int>& nums,vector<bool>& chosed,vector<int>& temp){
        if(temp.size()==nums.size()){
            ans.push_back(temp);
            return ;
        }
        for(int i=0;i<nums.size();i++){
            if(!chosed[i]){
                chosed[i] = true;
                temp.push_back(nums[i]);
                trace(nums,chosed,temp);
                chosed[i] = false;
                temp.pop_back();
            }
        }
    }

};