package Week_01.G20200343040246;

public class MoveZeroes {
    public static void main(String[] args) {
        
    }

    public class Solution {
        public void moveZeroes(int[] nums) {
            // 1: double point, O(n)
            for (int i = 0, j = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    swap(nums, i, j);
                    j++;
                }
            }
        }



        public void swap(int[] nums, int i, int j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
        }
    }

}