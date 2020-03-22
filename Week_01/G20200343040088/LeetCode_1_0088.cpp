class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> mapTemp;
        for (int i = 0; i < nums.size(); i++) {
            mapTemp.insert(std::make_pair(nums[i], i));
        }

        vector<int> vecRet;
        for (int j = 0; j < nums.size(); j++) {
            if (mapTemp.find(target - nums[j]) != mapTemp.end()) {
                if (mapTemp[target - nums[j]] == j) continue;
                vecRet.push_back(j);
                vecRet.push_back(mapTemp[target - nums[j]]);
                break;
            }
        }
        return vecRet;
    }
};
