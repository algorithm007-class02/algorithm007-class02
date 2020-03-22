class Solution{
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        // 使用快慢指针的方式对数组进行修改
        int j = 0;// 慢指针
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;//慢指针往前走
                nums[j] = nums[i]; //将快指针的值赋值给慢指针的下一个值，相当于把中间相等的值拿掉
            }
        }
        return j + 1; //最后的长度为慢指针+1 快指针跑完整个数组，慢指针指向最后一个不相同的元素
    }
}
public class LeetCode_26_0052 {

}
