

//解法一，暴力解法，还原每次旋转步骤，执行效率很低，执行用时318ms，时间复杂度O(k*n),空间复杂度O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        for(int i = 0; i < k; i++){
            int p = nums[nums.length-1];
            for(int j = 0; j < nums.length ; j++){
                int tmp = nums[j];
                nums[j] = p;
                p = tmp;
            }
        }
    }
}
//解法二,使用新数组存储更换后的数据，再更新原数组。时间复杂度O(n),空间复杂度O(n)。
class Solution {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }
}
//解法三，环状替换。时间复杂度O(n),空间复杂度O(1)。
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
//解法四，反转，先反转整个数组，然后根据k来分区间分别旋转。时间复杂度O(n),空间复杂度O(1)。
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

//本题没有思路，所以直接看了题解，解法三有点难以理解。