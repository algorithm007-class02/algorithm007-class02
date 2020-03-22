class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length == 0 || nums2.length == 0) return;
        int indexM = m-1,indexN = n-1,last = m+n-1;
        while(last >= 0){
            if(indexM < 0) {
                nums1[last--] = nums2[indexN--];
                continue;
            }
            if(indexN < 0) break;
            if(nums1[indexM] > nums2[indexN]){
                nums1[last--] = nums1[indexM--];
            }else{
                nums1[last--] = nums2[indexN--];
            }
        }
    }
}