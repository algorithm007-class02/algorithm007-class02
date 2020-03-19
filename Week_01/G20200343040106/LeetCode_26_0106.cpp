class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(!nums.size())
            return 0;
        int i;
        int j;
        for(i=0,j=1;j<nums.size();j++){
            if(nums[i]!=nums[j])
                nums[++i] = nums[j];
        } 
        return i+1;
    }
};
