class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int> m;
        for(int i = 0; i < nums.size(); ++i){
            if(m.count(target - nums[i]) >= 1){
                return {i, m[target - nums[i]]};
            }
            m.insert({nums[i], i});
        }
        return {};
    }
};