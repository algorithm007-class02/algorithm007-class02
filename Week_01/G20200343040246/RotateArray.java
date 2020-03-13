package Week_01.G20200343040246;

public class RotateArray {
    public static void main(String[] args) {
        
    }

    public class Solution {

        public void rotate(int[] nums, int k) {
            // 1: fore solution
            int temp, previous;
            for (int i = 0; i < k; i++) {
                previous = nums[nums.length - 1];
                for (int j = 0; j < nums.length; j++) {
                    temp = nums[j];
                    nums[j] = previous;
                    previous = temp;
                }
            }
        }


        public void rotate1(int[] nums, int k) {
            // 2: 分段反转, O(n)
            int length = nums.length;
            k = length - k % length;
            if(k == 0) return;
            
            reverse(nums, 0, k-1);
            reverse(nums, k, length-1);
            reverse(nums, 0, length-1);
        }
    
        public void reverse(int[] nums, int start, int end) {
            for(int i = start,j = end; i < j; i++, j--) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
    }

}