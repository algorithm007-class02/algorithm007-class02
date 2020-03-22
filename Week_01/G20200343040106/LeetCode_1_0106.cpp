

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ans;
        unordered_map<int,int> record;
        int temp[2];
        for(int i=0;i<nums.size();i++){
            if(record.find(target-nums[i])!=record.end()){
                temp[0] = record[target-nums[i]];
                temp[1] = i;
                return vector(temp,temp+2);
            }
            record[nums[i]] = i;
        }
        return ans;
    }
};
