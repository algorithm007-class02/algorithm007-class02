class Solution {
public:
    int maxProduct(vector<int>& nums) {
        /*
        *   the main idea is that we maintain two varible
        *   negmax: the most smallest and negtive subsequence prodeuct number of before index
        *   posmax: the most larger and postive subsequence product number of before index
        */

        int n = nums.size();
        if(n==0) return 0;
        if(n==1) return nums[0];
        int negmax = 0;
        int posmax = 0;
        int ans = INT_MIN;
        for(int i=0;i<n;i++){
            int pos = max(nums[i],max(nums[i]*posmax,nums[i]*negmax));
            int neg = min(nums[i],min(nums[i]*posmax,nums[i]*negmax));
            posmax = pos;
            negmax = neg;
            ans = max(ans,max(posmax,negmax));
        }
        return ans;
    }
};