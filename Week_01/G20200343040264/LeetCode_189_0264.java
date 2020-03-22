class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        //三次反转完成操作
        reverse(0,nums.length-1,nums);
        reverse(0,k-1,nums);
        reverse(k,nums.length-1,nums);
    }
    //数组反转的
    private void reverse(int start,int end,int[] nums){
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}