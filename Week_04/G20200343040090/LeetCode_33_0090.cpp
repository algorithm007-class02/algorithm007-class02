/*
33. 搜索旋转排序数组
*/

class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(0 == nums.size())
        {
            return -1;
        }

        int start = 0;
        int end = nums.size() - 1;
        int mid = 0;

        while(start <= end)
        {
            mid = start + (end - start)/2;

            if(target == nums[mid])
            {
                return mid;
            }

            /* 找有序的一边，对有序的一边进行target判断 */
            if(nums[start] <= nums[mid])
            {
                if(target >= nums[start] && target <= nums[mid])
                {
                    end = mid - 1;
                }
                else
                {
                   start = mid + 1; 
                }
            }
            else
            {
                if(target >= nums[mid] && target <= nums[end])
                {
                    start = mid + 1;
                }
                else
                {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
};