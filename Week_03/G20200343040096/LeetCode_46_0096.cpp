class Solution {
public:
    void permuteHelper(vector<int>& nums,int begin, vector<vector<int>>& res){
        if(begin >= nums.size()){
          res.emplace_back(nums);
          return;
        }
        for(int i = begin; i < nums.size(); ++i){
          swap(nums[i], nums[begin]);
          permuteHelper(nums, begin + 1, res);
          swap(nums[i], nums[begin]);
        }
    }

    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        if(nums.size() == 0) return res;
        permuteHelper(nums, 0, res);
        return res;
    }
};
