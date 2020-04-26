class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n==0) return 0;
        int a = 0;
        int b = nums[0];
        for(int i=1;i<n;i++){
            int tempmax = max(a+nums[i],b);
            a = b;
            b = tempmax;
        }
        return max(a,b);
    }
};