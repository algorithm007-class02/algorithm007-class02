
class Solution {
		//两次遍历
		// 时间复杂度:O(n)
		// 空间复杂度:O(1)
		/* public static void moveZeroes(int[] nums) {
			//如果数组为零直接返回
			if(nums==null ) {
				return;
			}
			//双指针操作
			int j=0;
			
			for (int i = 0; i < nums.length; i++) {
				if (nums[i]!=0) {	
					nums[j] = nums[i];
					j++;
				}
			}
			// for (int i = j; i < nums.length; i++) {
			// 	nums[i]=0;
			// }
			while (j < nums.length) {
				nums[j]=0;
				j++;
			}
		} */
		//一次遍历
     /* public static void moveZeroes(int[] nums) {
		if (nums==null) {
			return;
		}

		int temp;
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]!=0) {
				temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				j++;
			}
		}
	} */

	
		
	public static void main(String[] args) {
		int nums[] = {0,1,0,3,12};
		moveZeroes(nums);
	}

	public static void moveZeroes(int[] nums) {
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0)
                count++;
            else if(count >0){
                nums[i-count] = nums[i];
                nums[i] = 0;
            }
        }
    }
}	
