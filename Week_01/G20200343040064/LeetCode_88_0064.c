/**
 * 88.合并两个有序数组
 * 
 * */

void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n)
{
    int last = m+n-1;
    int p1=m-1,p2=n-1;
    while(p2>=0) {
        if((p1<0)||(nums1[p1] < nums2[p2])) {
            nums1[last--] = nums2[p2--];
        }
        else {
            nums1[last--] = nums1[p1--];
        }
    }
}
