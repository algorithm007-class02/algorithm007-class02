//额外数组
//我们可以用额外数组来存放正确位置
public class Solution{
    public void rotate(int[] nums, int k)
    {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[ (i+k) % nums.length ] = nums[i];
        } 
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}