class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
      //必须先排序
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        helper(nums, 0, res);
        return res;
    }

    void helper(vector<int> nums, int begin, vector<vector<int>>& result){
        if(begin >= nums.size()){
            result.emplace_back(nums);
            return;
        }
        for(int i = begin; i < nums.size(); ++i){
            if(i != begin && nums[i] == nums[begin]) continue;
            swap(nums[i], nums[begin]);
            helper(nums, begin + 1, result);
        }
    }
};
