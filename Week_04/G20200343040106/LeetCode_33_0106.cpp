class Solution {
public:
    int search(vector<int>& nums, int target) {
        int n = nums.size();
        if(n==0)
            return -1;
        int l = 0;
        int r = n-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target) return mid;
            //当左侧有序
            if(nums[l]<=nums[mid]){
                //当target位于左侧
                if(nums[l]<=target&&nums[mid]>target)
                    r = mid-1;
                else
                    l =mid+1;
            }else {   //右侧有序
                //target位于右侧
                if(nums[mid]<target&&nums[r]>=target)
                    l = mid+1;
                else    
                    r = mid-1;
            }
        }

        return -1;
    }
};