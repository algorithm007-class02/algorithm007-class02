class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       // 因为是有序数组，并且为了不插入数组覆盖原来的数据，因此从后面开始比较

       int num1Index = m - 1;
       int num2Index = n - 1;

       for (int i = m + n - 1; i >= 0; i --) {
           if (num1Index < 0) {
               nums1[i] = nums2[num2Index--];
           } else if (num2Index < 0 ) {
               nums1[i] = nums1[num1Index--];
           } else if (nums1[num1Index] > nums2[num2Index]) {
               nums1[i] = nums1[num1Index--];
           } else {
               nums1[i] = nums2[num2Index--];
           }
       }
    }
}