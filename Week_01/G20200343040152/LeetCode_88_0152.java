class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums1Copy = new int[m];
        System.arraycopy(nums1,0,nums1Copy,0,m);
        
        // num1Copy pointer
        int p1 = 0;
        // nums2 pointer
        int p2 = 0;
        // nums1 pointer
        int p = 0;

        while((p1<m) && (p2<n)) {
            nums1[p++] = nums1Copy[p1]<nums2[p2]?nums1Copy[p1++]:nums2[p2++];
        }
        if(p1<m) {
            System.arraycopy(nums1Copy,p1,nums1,p1+p2,m+n-p1-p2);
        }else if(p2<n) {
            System.arraycopy(nums2,p2,nums1,p1+p2,m+n-p2-p1);
        }
    }
}