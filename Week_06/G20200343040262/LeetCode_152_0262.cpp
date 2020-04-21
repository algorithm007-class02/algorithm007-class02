class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int imax = 1;//保存最大值
        int imin = 1;//保存最小值
        int result = INT_MIN;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] < 0) {
                swap(imax, imin);//数组值为负数，则最大将变最小，最小将变最大，因此交换即可
            }
            imax = max(imax * nums[i], nums[i]);
            imin = min(imin * nums[i], nums[i]);
            result = max(result, imax);
        }
        return result;
    }
};