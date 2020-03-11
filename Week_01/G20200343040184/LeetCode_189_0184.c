/**
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
class Solution {
public:
    /**
     * 方法一：暴力迭代 k * n 次，时间复杂度O(k*n) 
     * 执行超时了
     */
    void rotate(vector<int>& nums, int k) {
        int len = nums.size();
        for (int i = 0; i < k; i++)
        {
            int tail = nums[len-1];
            for (int j = 0; j < len; j++)
            {
                int tmp = nums[j];
                nums[j] = tail;
                tail = tmp;
            }
        }
    }
};