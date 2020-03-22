class Solution {
public:
    // // Very concise: not recommend, error-prone
    // void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
    //     int i = m-- + --n;
    //     while (n >= 0) {
    //         nums1[i--] = (m >= 0 && nums1[m] > nums2[n]) ? nums1[m--] : nums2[n--];
    //     }
    // }

    // More clarified: recommend for this question
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int validNum = m + n;
        while (n > 0) {
            if (m > 0 && nums1[m-1] > nums2[n-1]) { //
                nums1[validNum-1] = nums1[m-1];
                m--;
            } else {
                nums1[validNum-1] = nums2[n-1];
                n--;
            }
            validNum--;
        }
    }
};
