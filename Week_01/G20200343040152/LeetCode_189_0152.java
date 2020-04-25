class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(nums.length == 0 || k == 0) {
            return;
        }
        reverseNums(nums,0,nums.length-1);
        reverseNums(nums,0,k-1);
        reverseNums(nums,k,nums.length-1);
    }

    public void reverseNums(int[] nums,int start,int end){
        int temp;
        while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}