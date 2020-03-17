class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if(length <= 1 || k%length==0)return;
        k %= length;
        reverse(nums,0,length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,length-1);
    }

    public void rotate1(int[] nums, int k) {
        int count = 0,length = nums.length;
        for(int start = 0;count<length;start++){
            int current = start;
            int preV = nums[start];
            do{
                int next = (current+k)%length;
                int tempV = nums[next];
                nums[next] = preV;
                preV = tempV;
                current = next;
                count++;
            }while(start != current)
        }
    }


    private void reverse(int[] nums,int start,int end){
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