package Week_09.G20200343040246;

import java.util.Arrays;

public class LeetCode_300_0246 {
    
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(new LeetCode_300_0246().lengthOfLIS(nums));
        System.out.println(new LeetCode_300_0246().lengthOfLIS1(nums));
    }

    // 动态规划：O(n^2)
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 动态规划 + 二分查找
    public int lengthOfLIS1(int[] nums) {
        if(nums.length == 0) return 0;
        // tail数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
        int[] tail = new int[nums.length];
        tail[0] = nums[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[end]) {
                tail[++end] = nums[i];
            } else {
                int l = 0, r = end;
                while(l < r) {
                    int mid = l + ((r - l) >>> 1);
                    if (tail[mid] < nums[i]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                tail[l] = nums[i];
            }
        }
        return ++end;
    }

}