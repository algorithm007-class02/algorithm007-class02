class Solution {
  //用移动零的算法来做的
  public int removeDuplicates(int[] nums) {
    Arrays.sort(nums);
    int i = 0;
    int j = 1;
    int k = 0;
    while (true) {
      if (j < nums.length) {
        if (nums[i] == nums[j]) {
          nums[j] = 2147483647;
          j++;
        } else {
          i = j;
          j++;
          k++;
        }
      } else {
        break;
      }
    }
    Arrays.sort(nums);
    return k;
  }
}