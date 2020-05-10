class Solution {
  public int reversePairs(int[] nums) {
    return mergeSortedAndCount(nums,0,nums.length - 1) ;
  }
  public void merge (int[] nums , int startIndex , int midIndex , int endIndex) {
    int leftIndex = startIndex ;
    int rightIndex = midIndex + 1 ;
    int i = 0 ;
    int[] newArray = new int[endIndex-startIndex+1] ;
    while (leftIndex <= midIndex && rightIndex <= endIndex) {
      if ( nums[leftIndex] < nums[rightIndex]) {
        newArray[i++] = nums[leftIndex++] ;
      }else {
        newArray[i++] = nums[rightIndex++] ;
      }
    }
    while (leftIndex <= midIndex) {
      newArray[i++] = nums[leftIndex++] ;
    }
    while (rightIndex <= endIndex) {
      newArray[i++] = nums[rightIndex++] ;
    }
    for (int j=0 ; j< endIndex - startIndex +1 ; j++ ) {
      nums[startIndex + j] = newArray[j] ;
    }
  }

  public int mergeSortedAndCount(int[] nums, int startIndex , int endIndex) {
    if (startIndex < endIndex) {
      int count = 0 ;
      int midIndex = (startIndex + endIndex) >> 1 ;
      count += mergeSortedAndCount(nums,startIndex,midIndex) + mergeSortedAndCount(nums,midIndex+1,endIndex);
      int leftIndex = startIndex ;
      int rightIndex = midIndex + 1 ;
      while (leftIndex <= midIndex && rightIndex <= endIndex) {
        if (  (long)nums[leftIndex] > (2*(long)nums[rightIndex])) {
          count += midIndex - leftIndex + 1 ;
          rightIndex ++ ;
        } else {
          leftIndex ++ ;
        }
      }
      merge(nums , startIndex , midIndex , endIndex) ;
      return count ;
    } else
      return 0 ;
  }
}