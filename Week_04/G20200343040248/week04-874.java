class Solution {
    public int searchDisOrderPoint(int[] disorder) {
        int left = 0;
        int right = disorderArray.length-1;
        int mid = 0;
        while (left < right){
            mid = left + (right - left) / 2;
            if(disorder[min] > disorder[mid-1]){
                if(disorder[mid] < disorder[mid + 1]){
                    left = mid + 1;
                }else {
                    return mid;
                }
            }else{
                right = mid - 1;
            }
        }
    }
}

//使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
//如果mid的位置，大于前一个并且大于后一个，说明它是无序的点
//如果mid的位置, 大于前一个并且小于后一个说明无序在后面
//如果mid的位置，小于前一个说明无序在前面