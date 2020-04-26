/*
*   这个题与198区别在于，首尾房子相连了
*   那么我们可以分别计算rob(0,n-2)和rob(1,n-1)两个子问题。
*/

class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n==0) return 0;
        if(n==1) return nums[0];
        return max(helper(nums,0,n-2),helper(nums,1,n-1));
    }
    int helper(vector<int>& nums,int start,int end){
        int premax1 = 0;
        int premax2 = 0;
        for(int i=start;i<=end;i++){
            int temp = max(premax1+nums[i],premax2);
            premax1 = premax2;
            premax2 = temp;
        }
        return max(premax1,premax2);
    }
};