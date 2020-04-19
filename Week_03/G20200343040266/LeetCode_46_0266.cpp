class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        int n=nums.size();
        backtrack(ans,nums,{});
        return ans;
    }
    void backtrack(vector<vector<int>>& ans,vector<int> nums,vector<int> cur){
        if (nums.size()==0){
            ans.push_back(cur);
            return;
        }
        for (int i=0;i<nums.size();++i){
            auto nums1=nums;
            cur.push_back(nums[i]);
            nums1.erase(nums1.begin()+i);
            backtrack(ans,nums1,cur);
            cur.pop_back();
        }
    }
};