class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - nums2.length;
        for (int i = 0; i < nums2.length; i++) {
            nums1[index + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}