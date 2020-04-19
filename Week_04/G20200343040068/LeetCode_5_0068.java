class LeetCode_5_0068 {

    //使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
    //[3 , 4, 5, 6, 7, 0, 1, 2]
    public int getDisOrderIndex(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        return helper(arr,0,arr.length);
    }

    public int helper(int[] arr,int start,int end){
        if (start == end ) return -1;
        int mid = (start+end)/2;
        if (mid > 1 && arr[mid] < arr[mid -1]) return mid;
        if ((mid + 1) < arr.length && arr[mid + 1] < arr[mid]) return mid + 1;
        if (arr[start] < arr[mid]) {
            return helper(arr,mid + 1,end);
        } else {
            return helper(arr,start,mid -1);
        }
    }
}