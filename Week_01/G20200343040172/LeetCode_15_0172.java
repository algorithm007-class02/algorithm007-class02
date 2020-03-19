package Week_01.G20200343040172;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 思路：
 * 1、三重循环暴力求解
 * 2、排序以后使用双指针
 */
public class LeetCode_15_0172 {

    /**
     * 解答错误
     * 错误原因：
     * 需要进行去重，三重循环也会超时
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumSolution_2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        ans.add(temp);
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 使用双指针的解法
     *
     * 代码来源于LeetCode
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumSolution_1(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums); // 快排，O(logn)的时间复杂度
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            //TODO 为什么需要控制i>0?，判断条件的意思是若当前的num[i]与上一个num[i]即num[i-1]得值相同，
            // 则跳过当前的num[i]，所以需要保证i-1>0，避免数组越界
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }
}
