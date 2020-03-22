class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;//数组1下标
        int p2 = n-1;//数组2下标
        int p = m+n-1; //从后面开始合并

        //赋值
        while (p1>=0 && p2>=0) {
            nums1[p--] = nums1[p1] > nums2[p2]?nums1[p1--]:nums2[p2--];
        }
        //处理剩下的数据
        if (p2>=0){
            System.arraycopy(nums2,0,nums1,0,p2+1);
        }
    }
}