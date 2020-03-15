class Solution {
public:
    // // Solution 1: need O(N) space
    // void rotate(vector<int>& nums, int k) {
    //     std::vector<int> tmp(nums.size());
    //     for (int i = 0; i < nums.size(); i++) {
    //         tmp[(i + k) % nums.size()] = nums[i];
    //     }
    //     nums.assign(tmp.begin(), tmp.end());    //Another efficient way: nums.swap(tmp);
    // }

    // Solution 2: need O(1) space
    void rotate(vector<int>& nums, int k) {
        if (k < 1) return;
        
        int validNum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int curValue = nums[i];
            int nextValue = nums[i];
            int curIndex = i;
            while (curIndex == i || curIndex % nums.size() != i) {
                nextValue = nums[(curIndex + k) % nums.size()];
                nums[(curIndex + k) % nums.size()] = curValue;
                curValue = nextValue;
                curIndex += k;
                validNum++;
            }
            if (validNum >= nums.size()) {
                break;
            }
        }
    }
};
