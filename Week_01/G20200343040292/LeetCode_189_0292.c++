class Solution {
public:
    void rotate(vector<int>& nums, int k) {
         int length = nums.size();
        vector<int> vecTemp(length);
        
        for (int i = 0; i < length; i++) {
            vecTemp[i] = nums[i];
        }
        
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = vecTemp[i];
        }
    }
};