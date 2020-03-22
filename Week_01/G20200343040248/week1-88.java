class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0 ; i < nums2.length ; i++){
            nums1[i+m] = nums2[i];
        }
        int temp = 0;
        for(int i = 0; i < nums1.length-1; i++){
            for(int j = 0; j < nums1.length-i-1; j++){
                if(nums1[j+1] < nums1[j]){
                    temp = nums1[j+1];
                    nums1[j+1] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
    }
}

//自己的思路，先把num2放入num1后面组成完整地数组，然后再排序。
//查看解法，因为我自己不是做java的，才发现java有自带的方法
//解法一
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
//解法二，因为输出num1，所以需要一个新数组存储num1的值，然后对比num1和num2的值，把小值放入num1数组，多余的放到后面。
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }
}
//解法三，由于num1的空间大于等于m+n，所以这个解法从后面往前的顺序排序放入，空间复杂度可以为O(1)。
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0))
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}