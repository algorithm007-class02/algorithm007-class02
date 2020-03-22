class LeetCode_4_0068 {
    public static void main(String[] args){
        LeetCode_4_0068 a = new LeetCode_4_0068();
        a.merge([1,2,3,0,0,0],3,[2,5,6],3);
    }

    //1。新建一个数组，取两个数组中较小的值插入
    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int[] nums3 = new int[m+n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            nums3[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }

        while (k < (m + n)) {
            nums3[k++] = (i == m) ? nums2[j++] : nums1[i++];
        }
        System.arraycopy(nums3,0,nums1,0,m+n);
    }
}