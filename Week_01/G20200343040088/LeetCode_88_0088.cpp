class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while( i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
};

// 方法1： 直接放到nums1, 然后nums1排序
// 方法2： 双指针， nums1 的指针 i 指向 m-1， nums2 的指针 j 指向 n-1. 另外一个指针指向 nums 的末尾
//        每次比较 i, j 的值，大的放后面，直到 i 小于 0 。  如果此时 j 大于 0， 则直接放后面