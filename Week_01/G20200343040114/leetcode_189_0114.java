/**
 * 
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处
*/

class Solution {
    public void rotate(int[] nums, int k) {
        // 暴力求解：其实就是把数组里面的数字往后面移动一位。
        // int n = nums.length;
        // int tmp, prev = 0;
        // for (int i = 0; i < k; i++) {
        //     prev = nums[n-1];
        //     for (int j = 0; j < n; j++){
        //         tmp = nums[j];
        //         nums[j] = prev;
        //         prev = tmp;
        //     }
        // }

        // int current, prev = 0;
        // int count = 0;
        // for (int start = 0; count < nums.length; start++){
        //      current = start;
        //      prev = nums[current];
        //      do {
        //         int next = (current + k) % nums.length;
        //         int tmp = nums[next];
        //         nums[next] = prev;
        //         prev = tmp;
        //         current = next; 
        //         count++;
        //      }while(current != start);
        // }
        k = k % nums.length;
        reverseArray(nums, 0, nums.length-1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, nums.length-1);
    }

   public void reverseArray(int[] nums, int l, int r){
       while(l < r) {
           int temp = nums[r];
           nums[r] = nums[l];
           nums[l] = temp;
           l++;
           r--;
       }
   }
}