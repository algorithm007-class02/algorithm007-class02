class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        return nums[n / 2];
    }
};


//分治是一种思路， 但是貌似ac不了
class Solution {
public:

    int countNum(vector<int> nums, int left, int right, int val){
        int count = 0;
        for(int i = left; i <= right; ++i){
            if(nums[i] == val) ++count;
        }
        return count;
    }

    int helper(vector<int> nums, int left, int right){
        if(left >= right) return nums[left];
        int mid = (right - left) / 2 + left;
        int leftRes = helper(nums, left, mid);
        int rightRes = helper(nums, mid + 1, right);
        int size = right - left + 1;
        if(countNum(nums, left, right, leftRes) > size / 2) return leftRes;
        if(countNum(nums, left, right, rightRes) > size / 2) return rightRes;
        return -1;
    }

    int majorityElement(vector<int>& nums) {
        return helper(nums, 0, nums.size() - 1);
    }
};
