class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int> valueToIndex;
        for (int i = 0; i < nums.size(); i++) {
            if (valueToIndex.find(nums[i]) != valueToIndex.end()) {
                return std::vector<int>{valueToIndex[nums[i]], i};
            } else {
                valueToIndex[target - nums[i]]  = i;
            }
        }
        return std::vector<int>{};
    }
};
