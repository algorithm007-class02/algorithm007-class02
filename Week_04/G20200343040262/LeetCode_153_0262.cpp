class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0;
        int high = nums.size() - 1;
        int min_num = nums[low];
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > nums[low]) {//左半部分有序
                min_num = min(min_num, nums[low]);
                low = mid + 1;
            }
            else if (nums[mid] < nums[low]){//右半部分有序
                min_num = min(min_num, nums[mid]);
                high = mid - 1;
            }
            else {//此时，只剩nums[low]和nums[high]未比较
                min_num = min(min_num, nums[low]);
                min_num = min(min_num, nums[high]);
                break;
            }
        }
        return min_num;
    }
};