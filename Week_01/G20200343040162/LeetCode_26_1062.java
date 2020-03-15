package Week01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 移除数组中重复的元素，计算数组大小
 * @Author fengyuting
 * @Date 2020/3/15
 **/
public class RemoveDuplicates {


    /**
     * 方法一: 此方法数据必须是有序的
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,2,3};
        int i =  removeDuplicates1(nums);
        System.out.println("新数组长度:"+i);
    }
}
