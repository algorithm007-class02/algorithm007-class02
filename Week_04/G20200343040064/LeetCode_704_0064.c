/**
 * 704. 二分查找
 * */

int search(int* nums, int numsSize, int target){
    int l=0,r=numsSize-1;
    while(l<=r) {
        int mid = (l+r)>>1;
        if(nums[mid] == target) return mid;
        (nums[mid] < target)?(l=mid+1):(r=mid-1);
    }
    return -1;
}
