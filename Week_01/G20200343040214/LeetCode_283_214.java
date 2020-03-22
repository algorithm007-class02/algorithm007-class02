import java.util.Arrays;

public class Solution283 {
    public static void main(String[] args) {
        int [] nums = new int[]{0,0,1,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int j = -1;
        for(int i=0; i< len; i++){
            if(nums[i] != 0){
                j += 1;
                // j 从 -1 开始如果非零就 +1  表示往前移动几位
                // 做交换即可
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
