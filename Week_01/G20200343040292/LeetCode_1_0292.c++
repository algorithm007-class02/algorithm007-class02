class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {   
        map<int, int> mp;
        for (int i = 0; i < nums.size(); i++) {
            int temp = target - nums[i];
            if (mp.find(temp) != mp.end()) {
                vector<int> vecIndex = {mp[temp], i};
                return vecIndex;
            }
            else {
                mp.insert(pair<int,int>(nums[i], i));
            }
        }
        return vector<int>();
    }   
};