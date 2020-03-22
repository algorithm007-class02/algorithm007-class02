/**
 * @Description: 将数组向右移动K个位置
 * @Author fengyuting
 * @Date 2020/3/15
 **/
public class RotateArray {

    /**
     * 整体向后一步一步移动
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        for (int i=0;i<k;i++){
            for (int j=0;j<nums.length-1;j++){
                int tmp=nums[j+1];
                nums[j+1]=nums[0];
                nums[0]=tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
        }

    }

}
